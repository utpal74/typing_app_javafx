package ut.javafx.app.typing.test;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class TypingApp extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		Scene scene = new Scene(new Pane());
		ViewSwitcher.setScene(scene);
		ViewSwitcher.switchView(View.HOME);
		
		stage.setScene(scene);
		stage.show();
		
	}

	public static void main(String[] args) {
		launch(args);
	}

}
