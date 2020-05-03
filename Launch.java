package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;


public class Launch extends Application {

	//public static Stage primaryStage = null;
	
		@Override
		public void start(Stage primaryStage) throws Exception {
			Parent root = FXMLLoader.load(getClass().getResource("splash.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.initStyle(StageStyle.UNDECORATED);
			primaryStage.show();
			//this.primaryStage = primaryStage;

		}
		
		public static void main(String[] args) {
			launch(args);
		}
}
		
