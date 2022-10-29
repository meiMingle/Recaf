package me.coley.recaf.workspace.resource;

import me.coley.recaf.code.ClassInfo;
import me.coley.recaf.code.OuterMethodInfo;
import me.coley.recaf.util.Multimap;
import me.coley.recaf.util.logging.Logging;
import me.coley.recaf.workspace.resource.source.ContentCollection;
import me.coley.recaf.workspace.resource.source.ContentSource;
import me.coley.recaf.workspace.resource.source.SourceType;
import org.slf4j.Logger;
import software.coley.instrument.ApiConstants;
import software.coley.instrument.Client;
import software.coley.instrument.data.ClassData;
import software.coley.instrument.data.ClassLoaderInfo;
import software.coley.instrument.message.MessageConstants;
import software.coley.instrument.message.broadcast.BroadcastClassMessage;
import software.coley.instrument.message.broadcast.BroadcastClassloaderMessage;
import software.coley.instrument.message.request.RequestClassMessage;
import software.coley.instrument.message.request.RequestClassloaderClassesMessage;
import software.coley.instrument.message.request.RequestClassloadersMessage;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Workspace unit that works through an agent {@link software.coley.instrument.Client}.
 *
 * @author Matt Coley
 */
public class AgentResource extends Resource {
	private static final Logger logger = Logging.get(AgentResource.class);
	private final Set<String> ignored = new HashSet<>();
	private final Set<ClassLoaderInfo> remoteLoaders = new HashSet<>();
	private final Multimap<Integer, ClassData, Set<ClassData>> remoteClasses = Multimap.from(new HashMap<>(), HashSet::new);
	private final Client client;

	/**
	 * @param client
	 * 		Instrumentation client.
	 */
	public AgentResource(Client client) {
		super(new AgentContentSource());
		this.client = client;
	}

	/**
	 * Setup client connection handling.
	 */
	public boolean setup() {
		try {
			software.coley.instrument.util.Logger.level = software.coley.instrument.util.Logger.DEBUG;
			client.setBroadcastListener((messageType, message) -> {
				switch (messageType) {
					case MessageConstants.ID_BROADCAST_LOADER:
						BroadcastClassloaderMessage loaderMessage = (BroadcastClassloaderMessage) message;
						remoteLoaders.add(loaderMessage.getClassLoader());
						break;
					case MessageConstants.ID_BROADCAST_CLASS:
						BroadcastClassMessage classMessage = (BroadcastClassMessage) message;
						ClassData data = classMessage.getData();
						if (data.getClassLoaderId() == ApiConstants.BOOTSTRAP_CLASSLOADER_ID)
							return;
						logger.info("BROAD: " + data.getName());
						put(data);
						break;
					default:
						// unknown broadcast packet
						break;
				}
			});
			// Try to connect
			if (!client.connect())
				throw new IOException("Client connection failed");
			// Request known classloaders
			client.sendAsync(new RequestClassloadersMessage(), loaderReply -> {
				for (ClassLoaderInfo loader : loaderReply.getClassLoaders()) {
					remoteLoaders.add(loader);
					int loaderId = loader.getId();
					if (loader.isBootstrap())
						continue;
					logger.info("LOADER: " + loader.getName());
					// Request all classes from classloader
					client.sendAsync(new RequestClassloaderClassesMessage(loaderId), classesReply -> {
						// TODO: If we close the workspace, this needs to stop
						logger.info("LOADER-CLASSES: " + loader.getId() + "-" + classesReply.getClasses().size());
						for (String name : classesReply.getClasses()) {
							if (getClass(loaderId, name) == null) {
								ClassData data = requestClass(loaderId, name);
								if (data != null)
									put(data);
							}
						}
					});
				}
			});
			return true;
		} catch (Throwable t) {
			logger.error("Could not setup connection to agent server, client connect gave 'false'");
			t.printStackTrace();
			return false;
		}
	}

	/**
	 * @param data
	 * 		Class to store.
	 */
	private void put(ClassData data) {
		remoteClasses.put(data.getClassLoaderId(), data);
		// TODO: We will eventually want to allow the resource to be handled such that each class-loader
		//  is in its own section that can be swapped through. We could also implement this as a custom
		//  'Resources' impl with a resource per each classloader. Any-way we look at it a proper implementation
		//  requires refactoring to the workspace API to represent the remote VM correctly.
		getClasses().put(ClassInfo.read(data.getCode()));
	}

	/**
	 * Close client connection.
	 */
	public void close() {
		try {
			client.close();
		} catch (IOException ex) {
			logger.error("Failed to cleanly close client connection", ex);
		}
	}

	/**
	 * Order of operations:
	 * <ol>
	 *     <li>Check for being runtime class, return {@code null} if so</li>
	 *     <li>Check local cache for instance</li>
	 *     <li>Request remote data from server</li>
	 * </ol>
	 *
	 * @param loaderId
	 * 		ID of classloader to look in.
	 * @param className
	 * 		Name of class to get.
	 *
	 * @return Current class information.
	 */
	private ClassInfo getClass(int loaderId, String className) {
		if (className.indexOf('.') >= 0)
			className = className.replace('.', '/');
		if (ignored.contains(className))
			return null;
		// Get local cached version
		return getClasses().get(className);
	}

	/**
	 * @param loaderId
	 * 		ID of classloader to look in.
	 * @param className
	 * 		Name of class to get.
	 *
	 * @return Remote data of class.
	 */
	private ClassData requestClass(int loaderId, String className) {
		logger.info("Request: " + className);
		ClassData[] wrapper = new ClassData[1];
		client.sendBlocking(new RequestClassMessage(loaderId, className), reply -> {
			if (reply.hasData()) {
				ClassData data = reply.getData();
				wrapper[0] = data;
			}
		});
		return wrapper[0];
	}

	/**
	 * @return Set of remote classloaders.
	 */
	public Set<ClassLoaderInfo> getRemoteLoaders() {
		return remoteLoaders;
	}

	/**
	 * @return Multimap of classloaders and their classes.
	 */
	public Multimap<Integer, ClassData, Set<ClassData>> getRemoteClasses() {
		return remoteClasses;
	}

	/**
	 * @param name
	 * 		Class name to check.
	 *
	 * @return {@code true} when recognized by the current runtime.
	 */
	private boolean isRuntimeClass(String name) {
		return RuntimeResource.get().getClasses().containsKey(name);
	}

	/**
	 * @param info
	 * 		Class info to check.
	 *
	 * @return {@code true} when recognized by the current runtime.
	 * For inner classes, the outer class name is checked as well.
	 */
	private boolean isRuntimeClass(ClassInfo info) {
		// Obvious check
		if (isRuntimeClass(info.getName()))
			return true;
		// Check for outer-class of inner classes
		OuterMethodInfo outerMethod = info.getOuterMethod();
		if (outerMethod != null && isRuntimeClass(outerMethod.getOwner()))
			return true;
		List<String> outerClassBreadcrumbs = info.getOuterClassBreadcrumbs();
		if (outerClassBreadcrumbs.isEmpty())
			return false;
		return isRuntimeClass(outerClassBreadcrumbs.get(0));
	}

	private static class AgentContentSource extends ContentSource {
		protected AgentContentSource() {
			super(SourceType.INSTRUMENTATION);
		}

		@Override
		protected void onRead(ContentCollection collection) {
			// no-op
		}

		@Override
		public String toString() {
			return "Remote MV";
		}
	}
}