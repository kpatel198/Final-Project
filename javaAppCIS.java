import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class javaAppCIS extends Application {
	Stage window;
	Scene scene;
	Button button;
	ComboBox<String> combobox;
	ListView<String> listview;
	TreeView <String> tree;
	//TableView<Products> table;
	TextField nameInput, priceInput, quantityInput;
	BorderPane layout;
	TextField securityQuestionTextField;
	String securityQuestionTextFieldString = "";
	ChoiceBox<String> securityQuestions;
	String securityQuestionChoiceBoxString="";
	TextField passwordTextField;
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		    launch(args);
			// Load the JDBC driver
		  	//  Class.forName("com.mysql.jdbc.Driver");
		    System.out.println("Driver loaded");

		    // Establish a connection
		    Connection connection = DriverManager.getConnection
		      ("jdbc:mysql://35.196.232.95:3306/test","root","");
		    System.out.println("Database connected");

		    // Close the connection
		    connection.close();
		  }
	@Override
	public void start(Stage arg0) throws Exception{
		mainMenu(arg0);
		
	}
	private void reservationPage(Stage arg0) {
		window = arg0;
		window.setTitle("Reserve Flights");
		
		//Creating gridpane 
		GridPane registrationGrid = new GridPane();
		registrationGrid.setPadding(new Insets(10,10,10,10));
		registrationGrid.setVgap(8);
		registrationGrid.setHgap(10);
		
		//create Buttons 
		Button backButton = new Button ("Back");
		Button reserveButton = new Button ("Reserve");
		GridPane.setConstraints(backButton,0,10);
		GridPane.setConstraints(reserveButton,2,10);	
		
		//Create labels
		Label fromCityLabel= new Label("Flying From: ");
		GridPane.setConstraints(fromCityLabel,0,0);
		Label toCityLabel= new Label("Flying to: ");
		GridPane.setConstraints(toCityLabel,2,0);
		Label dateFromLabel= new Label("Trip starts on: ");
		GridPane.setConstraints(dateFromLabel,0,3);
		Label dateBackLabel= new Label("Trip ends on: ");
		GridPane.setConstraints(dateBackLabel,2,3);
		Label passengerNumberLabel= new Label("Number of Passengers: ");
		GridPane.setConstraints(passengerNumberLabel,0,6);
		Label timeLabel= new Label("Time preferrence: ");
		GridPane.setConstraints(timeLabel,2,6);
		Label errorPassenger = new Label ("Enter valid number of passengers");
		Label errorDate = new Label ("Enter valid dates");
		
		//create textfields and others 
		TextField fromCityTextfield = new TextField();
		fromCityTextfield.setPromptText("Enter Departing city");
		GridPane.setConstraints(fromCityTextfield,0,1);
		TextField toCityTextfield = new TextField();
		toCityTextfield.setPromptText("Enter Destination city");
		GridPane.setConstraints(toCityTextfield,2,1);
		DatePicker dateFromTextfield= new DatePicker();
		GridPane.setConstraints(dateFromTextfield,0,4);
		DatePicker dateBackTextfield= new DatePicker();
		GridPane.setConstraints(dateBackTextfield,2,4);
		TextField passengerNumberTextfield = new TextField();
		passengerNumberTextfield.setPromptText("Number of Passengers");
		GridPane.setConstraints(passengerNumberTextfield,0,7);
		
		
		//creating a dropdown for time picker 
		ChoiceBox <String> timepicker = new ChoiceBox<>();
		timepicker.getItems().addAll("None","4:00","8:00","12:00","16:00 (4:00 PM)","20:00 (8:00 PM)");
		timepicker.setValue("None");
		GridPane.setConstraints(timepicker,2,7);
		
		registrationGrid.getChildren().addAll(fromCityLabel,toCityLabel,dateFromLabel,
												dateBackLabel,passengerNumberLabel,timeLabel,
												fromCityTextfield,toCityTextfield,dateFromTextfield,
												dateBackTextfield,passengerNumberTextfield,timepicker,
												backButton,reserveButton);
		
		reserveButton.setOnAction(e -> {
			try {
				Integer.parseInt(passengerNumberTextfield.getText());
				registrationGrid.getChildren().remove(errorPassenger);
				
			}catch(Exception ex) {
				errorPassenger.setStyle("-fx-font-size: 5pt;"+
										"-fx-text-fill: red;");
				GridPane.setConstraints(errorPassenger,0,8);
				registrationGrid.getChildren().add(errorPassenger);
			}
			try {
				if ((dateFromTextfield.getValue()).compareTo(dateBackTextfield.getValue()) >0) {
					int a = 11/0;
				}
				registrationGrid.getChildren().remove(errorDate);
			}
			catch(Exception ex) {
				errorDate.setStyle("-fx-font-size: 5pt;"+
								"-fx-text-fill: red;");
				GridPane.setConstraints(errorDate,0,5);
				registrationGrid.getChildren().add(errorDate);
			}
		});
		
		backButton.setOnAction(e->mainMenu(arg0));
		
		Scene scene = new Scene (registrationGrid,400,400);
		window.setScene(scene);
		window.show();
	}
	private void forgotPasswordPage(Stage arg0) {
		window = arg0;
		window.setTitle("Forgot Password Page");
		
		String securityQuestion = securityQuestions.getValue();
		
		//Create labels 
		Label securityQuestionForgotPassword = new Label(securityQuestion);
		Label userNameForgotPassword = new Label("Username:");
		
		//Create Textfields 
		TextField securityAnswerForgotPassword = new TextField();
		securityAnswerForgotPassword.setPromptText("Enter your answer here");
		TextField userNameForgotPasswordAnswer = new TextField();
		
		if (userNameForgotPasswordAnswer.getText().equals("User1")&& 
				securityAnswerForgotPassword.getText().equals(securityQuestionTextField.getText())) {
			
			System.out.println("Correct");
			
			VBox newPasswordPrompt = new VBox(10);
			newPasswordPrompt.setPadding(new Insets(10,10,10,10));
			newPasswordPrompt.getChildren().add(passwordTextField);
			
			Button next = new Button("Submit");
			next.setOnAction(e -> {
				if(passwordTextField.getText().length()>6) {
					reservationPage(arg0);
				}
				else {
					System.out.println("Enter password with characters more than 6");
				}
			});
			
			
			scene = new Scene (newPasswordPrompt,200,200);
			window.setScene(scene);
			window.show();	
			
			
		}
		HBox question = new HBox(10);
		question.getChildren().addAll(securityQuestionForgotPassword,securityAnswerForgotPassword);
		
		HBox userName = new HBox(10);
		userName.getChildren().addAll(userNameForgotPassword,userNameForgotPasswordAnswer);
		
		VBox combine = new VBox(15);
		combine.getChildren().addAll(question,userName);
		combine.setPadding(new Insets(10,10,10,10));
		
		scene = new Scene (combine,200,200);
		window.setScene(scene);
		window.show();	
		
		
	}
	private void registrationPage(Stage arg0) {
		window = arg0;
		window.setTitle("Registration Page");
		
		//creating labels 
		Label firstNameLabel= new Label("First Name: ");
		Label secondNameLabel= new Label("Second Name: ");
		Label addressLabel1= new Label("Street Address 1: ");
		Label addressLabel2= new Label("Street Address 2: ");
		Label cityLabel= new Label("City: ");
		Label stateLabel= new Label("State: ");
		Label zipcodeLabel= new Label("Zipcode: ");
		Label emailLabel= new Label("Email: ");
		Label ssnLabel= new Label("Social Security Number: ");
		Label usernameLabel= new Label("Username: ");
		Label passwordLabel= new Label("Password: ");
		
		//creating textfields
		TextField firstNameTextField= new TextField();
		TextField secondNameTextField= new TextField();
		TextField addressTextField1= new TextField();
		TextField addressTextField2= new TextField();
		addressTextField2.setPromptText("Optional");
		TextField cityTextField= new TextField();
		TextField stateTextField= new TextField();
		TextField zipcodeTextField= new TextField();
		TextField emailTextField= new TextField();
		TextField ssnTextField= new TextField();
		TextField usernameTextField= new TextField();
		passwordTextField= new TextField();
		securityQuestionTextField= new TextField();
		securityQuestionTextField.setPromptText("Enter your answer to the security question here");
		
		//creating a drop-down list 
		securityQuestions = new ChoiceBox<>();
		securityQuestions.getItems().addAll("What was the house number and street name you lived in as a child?",
											"What were the last four digits of your childhood telephone number?",
											"What primary school did you attend?", 
											"In what town or city was your first full time job?",
											"In what town or city did you meet your spouse/partner?");
			

		//creating buttons 
		Button registerButton = new Button ("Register!");
		Button backButton = new Button ("Back");
		
		
		
		//setting action to buttons
		backButton.setOnAction(e-> {
			try {
				mainMenu(arg0);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		registerButton.setOnAction(e-> {
			securityQuestionTextFieldString= securityQuestionTextField.getText();
	
		});
		
		//creating Vboxs and Hboxs to display data 
		//First vbox to contain all the other layouts
		VBox mainVbox = new VBox();
		
		//creating Hbox for all the labels and textfields
		HBox entryFields = new HBox();
		entryFields.setPadding(new Insets(2,2,5,2));
			//this hbox will contain two vboxs
			VBox labels = new VBox(10);
			labels.setAlignment(Pos.CENTER);
				//adding labels to the vbox 
				labels.getChildren().addAll(firstNameLabel,secondNameLabel,addressLabel1,addressLabel2,cityLabel,
						stateLabel,zipcodeLabel,emailLabel,ssnLabel,usernameLabel,passwordLabel);
			VBox textFields = new VBox();
			textFields.setAlignment(Pos.CENTER);
				//adding textfields to vbox
				textFields.getChildren().addAll(firstNameTextField,secondNameTextField,addressTextField1,addressTextField2,
						cityTextField,stateTextField,zipcodeTextField,emailTextField,ssnTextField,
						usernameTextField,passwordTextField);
			//add the two new created vboxs to hbox
			entryFields.getChildren().addAll(labels,textFields);
		
		//create another hbox for the buttons 
		HBox buttonsHbox = new HBox();
		buttonsHbox.getChildren().addAll(backButton,registerButton);
		buttonsHbox.setPadding(new Insets(5,2,2,2));
				
		//adding all the components together
		mainVbox.getChildren().addAll(entryFields,securityQuestions,securityQuestionTextField, buttonsHbox);
		
		Scene scene = new Scene (mainVbox, 400,400);
		window.setScene(scene);
		window.show();
	}
	private void loginPage(Stage arg0) {
		window=arg0;
		window.setTitle("Login Page");
		//Create labels 
		Label usernameLabel = new Label ("Username: ");
		usernameLabel.setStyle("-fx-font-size: 12pt;");
		Label passwordLabel = new Label ("Password: ");
		passwordLabel.setStyle("-fx-font-size: 12pt;");
		
		//Create textfield 
		TextField usernameField = new TextField();
		usernameField.setPromptText("Enter username here");
		TextField passwordField = new TextField();
		passwordField.setPromptText("Enter password here");
		
		//Create Button
		Button loginButton = new Button("Login");
		Button backButton = new Button("Back");
		
		//Creating panes 
		GridPane pane = new GridPane();
		
		
		//adding action to button
		backButton.setOnAction(e -> {
			try {
				mainMenu(arg0);
			}
			catch(Exception ex) {
				System.out.println("Error going back");
			}
		});
		loginButton.setOnAction(e->{
			if(usernameField.getText().equals("User1") && passwordField.getText().equals("Pass1")) {
				pane.add(new Label(""), 5, 6);
				reservationPage(arg0);
			}
			else {
				pane.add(new Label("Wrong credentials."), 5, 6);
			}
		});
		
		
		//adding children to pane
		pane.add(usernameLabel, 1, 1,2,1);
		pane.add(passwordLabel, 1, 4,2,1);
		pane.add(usernameField, 4, 1,2,1);
		pane.add(passwordField, 4, 4,2,1);
		pane.add(loginButton, 5, 5);
		pane.add(backButton, 4, 5);
		
		
		scene = new Scene(pane, 300,300);
		window.setScene(scene);
		window.show();
	}
	private void mainMenu(Stage arg0) {
		window =arg0;
		window.setTitle("Main Menu");
		
		//Create two buttons ojects 
		Button login = new Button("Login");
		login.setOnAction(e -> loginPage(arg0));
		Button register = new Button("Register");
		register.setOnAction(e -> registrationPage(arg0));
		Button recoverPassword = new Button("Forgot Password?");
		recoverPassword.setOnAction(e -> forgotPasswordPage(arg0));
		Label blank = new Label("");
		//set button color
		login.setStyle("-fx-background-color: linear-gradient(to right, #808080,#404040);"
				+ "-fx-font-size: 20pt;"
				+ "-fx-text-fill: #CC6600;");
		register.setStyle("-fx-background-color: linear-gradient(to right, #808080,#404040);"
				+ "-fx-font-size: 20pt;"
				+ "-fx-text-fill: #CC6600;");
		recoverPassword.setStyle("-fx-background-color: linear-gradient(to left, #990000,#CC6600);"
				+ "-fx-font-size: 8pt;"
				+ "-fx-text-fill: #000000;");
		blank.setStyle("-fx-font-size: 4pt;");
		
		//creating menu bar
		MenuBar menu = new MenuBar();
		Menu home = new Menu("Home");
		home.getItems().add(new MenuItem("Go Home"));
		menu.getMenus().add(home);
		menu.setStyle("-fx-background-color: #994C00;");
		
		//Create vbox for layout type
		VBox pane = new VBox(20);
		pane.setPadding(new Insets(10,10,10,10));
		//customize the vbox 
		pane.setAlignment(Pos.CENTER);
		pane.getChildren().addAll(login,register,blank,recoverPassword);
		pane.setStyle("-fx-background-color: #0080FF");
		
		//create border pane
		BorderPane mainMenuBorderPane = new BorderPane();
		mainMenuBorderPane.setTop(menu);
		mainMenuBorderPane.setCenter(pane);
		
		//create new scene with vbox
		scene= new Scene(mainMenuBorderPane,500,500);
		window.setScene(scene);
		window.show();
	}
	

}
