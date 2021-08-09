package ut.javafx.app.typing.test;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;

public class MainController implements Initializable {

	@FXML
	private Label greetLabel;

	@FXML
	private Label autoCharLabel;

	@FXML
	private ProgressBar testProgressBar;

	@FXML
	private TextArea userInputArea;

	@FXML
	private Button submitTestBtn;

	private static int score = 0;
	private ScheduledExecutorService service = Executors.newScheduledThreadPool(5);
	private static List<String> inputList = new CopyOnWriteArrayList<>();
	private static List<String> resultList = new CopyOnWriteArrayList<>();
	private static double inputSize = CharProducer.getInputSize();

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		submitTestBtn.setDisable(true);
		greetLabel.setText(new HomeController().getMyName());
		beginTimer();

	}

	public void beginTimer() {

		service.schedule(() -> {
			String s = CharProducer.getRandomChar();
			autoCharLabel.setText(s);
			inputList.add(s);
		}, 0, TimeUnit.SECONDS);
		
		service.schedule(() -> {
			
			userInputArea.textProperty().addListener(new ChangeListener<String>() {

				@Override
				public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {

					if (resultList.size() == inputSize) {
						autoCharLabel.setDisable(true);
						userInputArea.setDisable(true);
						submitTestBtn.setDisable(false);
						service.shutdown();
						return;
					}

					if (userInputArea.getText().length() != 0) {
						resultList.add(userInputArea.getText());

						String s = CharProducer.getRandomChar();
						autoCharLabel.setText(s);
						inputList.add(s);

						double current = inputList.size();
						testProgressBar.setProgress(current / inputSize);
					}

				}
			});

			
		}, 3, TimeUnit.SECONDS);

	}

	public void submitTest() {
		ViewSwitcher.switchView(View.RESULT);
	}

	public static Integer getScore() {
		if (inputList.size() > inputSize) {
			inputList.remove(inputList.size() - 1);
		}

		for (int i = 0; i < inputSize; i++) {
			if (inputList.get(i).equals(resultList.get(i))) {
				score++;
			}
		}

		return score;
	}
	
	public static void reloadTest() {
		MainController.score = 0;
		MainController.inputList = new CopyOnWriteArrayList<>();
		MainController.resultList = new CopyOnWriteArrayList<>();		
	}

}
