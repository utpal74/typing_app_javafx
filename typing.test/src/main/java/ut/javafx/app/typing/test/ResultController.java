package ut.javafx.app.typing.test;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ResultController implements Initializable {
	
	@FXML
	private Label resultLabel, finalScoreLabel;
	
	@FXML
	private Button retakeTestBtn, closeTestBtn;
	
	public void retakeTest() {
		MainController.reloadTest();
		ViewSwitcher.switchView(View.MAIN);
	}
	
	public void closeTest() {
		Scene scene = ViewSwitcher.getScene();
		Stage stage = (Stage) scene.getWindow();
		stage.close();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		finalScoreLabel.setText(MainController.getScore() + "");
		
	}

}
