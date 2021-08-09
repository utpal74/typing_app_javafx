package ut.javafx.app.typing.test;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class HomeController implements Initializable {
	
	@FXML
	private TextArea testGuideLineArea;
	
	@FXML
	private TextField nameField;
	
	@FXML
	private Button startTestBtn;
	
	@FXML
	private Label name;	
	
	private static String myName;
	
	public void setName(String name) {
		myName = name;
	}
	
	public void startTest() {		
		this.setName("Hi, " + nameField.getText().trim());
		ViewSwitcher.switchView(View.MAIN);
	}
	
	public String getMyName() {
		return myName;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {		
		startTestBtn.setDisable(true);	
		
		nameField.textProperty().addListener(e -> {
			if (nameField.getText().length() > 0) {
				startTestBtn.setDisable(false);
			}
		});
		
	}

}
