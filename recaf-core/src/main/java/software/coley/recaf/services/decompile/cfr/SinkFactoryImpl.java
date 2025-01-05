package software.coley.recaf.services.decompile.cfr;

import jakarta.annotation.Nullable;
import org.benf.cfr.reader.api.OutputSinkFactory;
import org.benf.cfr.reader.api.SinkReturns;
import org.slf4j.Logger;
import software.coley.recaf.analytics.logging.Logging;

import java.util.*;

/**
 * Cfr logging/output sinker.
 *
 * @author Matt
 */
public class SinkFactoryImpl implements OutputSinkFactory {
	private static final Logger logger = Logging.get(SinkFactoryImpl.class);
	private Throwable exception;
	private String decompile;
	final NavigableMap<Integer, List<Integer>> lineMapping = new TreeMap<>();

	@Override
	public List<SinkClass> getSupportedSinks(SinkType sinkType, Collection<SinkClass> collection) {
		return Arrays.asList(SinkClass.values());
	}

	@Override
	public <T> Sink<T> getSink(SinkType sinkType, SinkClass sinkClass) {
		return switch (sinkType) {
			case JAVA -> this::setDecompilation;
			case EXCEPTION -> this::handleException;
			case LINENUMBER -> t -> {
				SinkReturns.LineNumberMapping mapping = (SinkReturns.LineNumberMapping) t;
				NavigableMap<Integer, Integer> classFileMappings = mapping.getClassFileMappings();
				NavigableMap<Integer, Integer> mappings = mapping.getMappings();//
				if (classFileMappings != null && mappings != null) {
					for (Map.Entry<Integer, Integer> entry : mappings.entrySet()) {
						Integer srcLineNumber = classFileMappings.get(entry.getKey());
						if (srcLineNumber == null) {
							continue;
						}
						List<Integer> numbers = lineMapping.get(entry.getValue());
						if (numbers == null) {
							numbers = new ArrayList<>();
							numbers.add(srcLineNumber);
							lineMapping.put(entry.getValue(), numbers);
						} else {
							if (!numbers.contains(srcLineNumber)) {
								numbers.add(srcLineNumber);
							}
						}
					}
				}
			};
			case PROGRESS -> t -> {

			};
			default -> t -> {

			};
		};
	}

	private <T> void handleException(@Nullable T value) {
		if (value instanceof Throwable) {
			logger.error("CFR Error: {}", value);
			exception = (Throwable) value;
		} else {
			logger.error("CFR encountered an error but provided no additional information");
		}
	}

	private <T> void setDecompilation(T value) {
		decompile = value.toString();
	}

	/**
	 * @return Decompiled class content.
	 */
	@Nullable
	public String getDecompilation() {
		return addLineNumber(decompile,lineMapping);
	}

	private static String addLineNumber(String src, Map<Integer, List<Integer>> lineMapping) {

		StringBuilder sb = new StringBuilder();

		int index = 0;
		try (Scanner sc = new Scanner(src)) {
			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				sb.append(line);
				List<Integer> srcLineNumbers = lineMapping.get(index + 1);
				if (srcLineNumbers != null) {
					srcLineNumbers.forEach(e->sb.append("// ").append(e).append(" "));
				}
				sb.append("\n");
				index++;
			}
		}
		return sb.toString();
	}

	/**
	 * @return Failure reason.
	 */
	@Nullable
	public Throwable getException() {
		return exception;
	}
}
