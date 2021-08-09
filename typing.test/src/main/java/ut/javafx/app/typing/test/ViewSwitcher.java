package ut.javafx.app.typing.test;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class ViewSwitcher {
	
	private static Scene scene;
	
	public static void setScene(Scene scene) {
		ViewSwitcher.scene = scene;				
	}
	
	public static Scene getScene() {
		return ViewSwitcher.scene;
	}
	
	public static void switchView(View view) {
		
		if (scene == null) {
			System.out.println("Scene is not set");
			return;
		}
		
		Parent root;
		
		try {
			
			root = FXMLLoader.load(
					ViewSwitcher.class.getResource(view.getFileName())
			);
			
			scene.setRoot(root);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	
}
