package software.coley.recaf.ui.window;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import javafx.scene.layout.BorderPane;
import software.coley.recaf.Bootstrap;
import software.coley.recaf.Recaf;
import software.coley.recaf.services.window.WindowManager;
import software.coley.recaf.ui.pane.LoggingPane;
import software.coley.recaf.ui.pane.ScriptManagerPane;
import software.coley.recaf.util.Lang;

/**
 * Window wrapper for {@link ScriptManagerPane}.
 *
 * @author Matt Coley
 * @see ScriptManagerPane
 */
@Dependent
public class ScriptManagerWindow extends AbstractIdentifiableStage {
	private final Recaf recaf = Bootstrap.get();
	@Inject
	public ScriptManagerWindow(ScriptManagerPane scriptManagerPane) {
		super(WindowManager.WIN_SCRIPTS);

		LoggingPane logging = recaf.get(LoggingPane.class);
		// Layout
		titleProperty().bind(Lang.getBinding("menu.scripting.manage"));
		setMinWidth(750);
		setMinHeight(450);
		BorderPane borderPane = new BorderPane(scriptManagerPane);
		borderPane.setBottom(logging);
		setScene(new RecafScene(borderPane, 750, 450));

	}
}
