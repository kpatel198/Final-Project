package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class SplashController implements Initializable {
	
	@FXML
	private AnchorPane parent;
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		FadeTransition.applyFadeTransition(parent,Duration.seconds(5),(e)-> {
			try {
				Parent fxml = FXMLLoader.load(getClass().getResource("login.fxml"));
				parent.getChildren().removeAll();
				parent.getChildren().setAll(fxml);
			} catch (IOException ex) {
				Logger.getLogger(SplashController.class.getName()).log(Level.SEVERE,null, ex);
			}
			
		});
	}
}

