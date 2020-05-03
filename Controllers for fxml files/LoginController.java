package application;

import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
	
	@FXML
	private AnchorPane parent, rootPane;
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		
	}
	
	@FXML
	private void loginButton(ActionEvent event) throws IOException {
		AnchorPane pane = FXMLLoader.load(getClass().getResource("login.fxml"));
		rootPane.getChildren().setAll(pane);
	}

}
