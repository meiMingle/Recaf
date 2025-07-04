package software.coley.recaf.ui.docking;

import jakarta.annotation.Nonnull;
import javafx.scene.input.MouseButton;
import software.coley.bentofx.Bento;
import software.coley.bentofx.building.HeaderFactory;
import software.coley.bentofx.control.ContentWrapper;
import software.coley.bentofx.control.Header;
import software.coley.bentofx.control.HeaderPane;
import software.coley.bentofx.control.Headers;
import software.coley.bentofx.dockable.Dockable;
import software.coley.bentofx.layout.container.DockContainerLeaf;
import software.coley.bentofx.layout.container.DockContainerRootBranch;

import java.util.List;

/**
 * An extension of {@link Bento} used for embedded circumstances.
 * We only want bento for docking layout + collapsible panels.
 * These should not handle any sort of drag-drop behaviors, allowing
 * any parent/containing bento content to behave properly.
 *
 * @author Matt Coley
 */
public class EmbeddedBento extends Bento {
	private static final String EMBEDDED_CLASS = "embedded-bento";

	/**
	 * New embedded bento.
	 */
	public EmbeddedBento() {
		// Construct without configuring drag-drop support
		controlsBuilding().setContentWrapperFactory(container -> new ContentWrapper(container) {
			@Override
			protected void setupDragDrop(@Nonnull DockContainerLeaf container) {
				// no-op
			}
		});
		controlsBuilding().setHeadersFactory((container, orientation, side) -> new Headers(container, orientation, side) {
			@Override
			protected void setupDragDrop(@Nonnull DockContainerLeaf container) {
				// no-op
			}
		});

		// Construct without initializing drag-drop event handling
		controlsBuilding().setHeaderFactory(Header::new);
	}

	@Override
	public boolean registerRoot(@Nonnull DockContainerRootBranch container) {
		List<String> styleClasses = container.getStyleClass();
		if (!styleClasses.contains(EMBEDDED_CLASS))
			styleClasses.add(EMBEDDED_CLASS);
		return super.registerRoot(container);
	}
}
