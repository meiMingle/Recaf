package software.coley.recaf.services.decompile.sporeflower;

import jakarta.annotation.Nonnull;
// import org.jetbrains.java.decompiler.main.extern.IContextSource;
import software.coley.recaf.info.JvmClassInfo;
import software.coley.recaf.workspace.model.Workspace;

import java.util.Collections;
import java.util.List;

/**
 * Full library source for sporeflower.
 *
 * @author Matt Coley
 * @author therathatter
 */
public class LibrarySource extends BaseSource {
	private final List<Entry> entries;

	/**
	 * @param entries
	 * 		List of context entries in the given workspace.
	 * @param workspace
	 * 		Workspace to pull class files from.
	 * @param targetInfo
	 * 		Target class to decompile.
	 */
	protected LibrarySource(@Nonnull List<Entry> entries, @Nonnull Workspace workspace, @Nonnull JvmClassInfo targetInfo) {
		super(workspace, targetInfo);
		this.entries = entries;
	}

	@Override
	public Entries getEntries() {
		return new Entries(entries, Collections.emptyList(), Collections.emptyList());
	}
}
