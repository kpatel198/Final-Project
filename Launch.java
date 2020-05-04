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
		//Register database insert
		String firstName = firstNameTextField.getText();
		String secondName = secondNameTextField.getText();
		String address = addressTextField1.getText();
		String state = stateTextField.getText();
		String zip= zipcodeTextField.getText();
		String username = usernameTextField.getText();
		String password = passwordTextField.getText();
		String ssn = ssnTextField.getText();
		String securityAnswer = securityQuestionTextField.getText();
		String securityQuestion = securityQuestions.getSelectionModel().getSelectedItem();
		try {
			Connection con = getConnection();
			PreparedStatement posted = con.prepareStatement("INSERT INTO customer (first, second, address, zip, state, username, password, ssn, securityqu, securityan) VALUES ('"+ firstName+ "','"+secondName+"','"+address+"','"+zip+"','"+state+"','"+username+"','"+password+"','"+ssn+"','"+securityQuestion+"', '"+securityAnswer+"')");
			posted.executeUpdate();
		}catch (Exception e1) {System.out.println(e1);}
		finally {
			System.out.println("Insert Completed.");
			}

			//login database
			loginButton.setOnAction(e->{
				ResultSet rs;
				String username = usernameField.getText();
		    String password = passwordField.getText();
				String query = "SELECT * FROM customer WHERE username =? AND password =?";
				try {
					Connection con = getConnection();
					PreparedStatement posted = con.prepareStatement(query);

					posted.setString(1, username);
		      posted.setString(2, password);
					rs = posted.executeQuery();
				} catch (Exception e1) {System.out.println(e1);}
				finally {
						System.out.println("Login Completed.");}
					});
}
