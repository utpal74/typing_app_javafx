package ut.javafx.app.typing.test;

public enum View {
	
	HOME("Home.fxml"),
	MAIN("Main.fxml"),
	RESULT("Result.fxml");	
	
	private String fileName;

	private View(String fileName) {
		this.fileName = fileName;
	}

	public String getFileName() {
		return fileName;
	}

}
