

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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

public class Tutorials extends Application {
	Stage window;
	Scene scene;
	Button button;
	ComboBox<String> combobox;
	ListView<String> listview;
	TreeView <String> tree;
	TableView<Products> table;
	TextField nameInput, priceInput, quantityInput;
	BorderPane layout;
	
	 public static void main(String[] args) throws SQLException, ClassNotFoundException {
		 
		 launch(args);
		 	/*
		 	// Load the JDBC driver
		    //Class.forName("com.mysql.jdbc.Driver");
		    System.out.println("Driver loaded");

		    // Establish a connection
		    Connection connection = DriverManager.getConnection
		      ("jdbc:mysql://34.66.230.235/cis-3730:us-central1:cis-3300","KushP19","myPass123");
		    System.out.println("Database connected");

		    // Create a statement
		    Statement statement = connection.createStatement();

		    // Execute a statement
		    ResultSet resultSet = statement.executeQuery
		      ("select firstName, mi, lastName from Student"); //where lastName "
		      //  + " = 'Smith'");

		    // Iterate through the result and print the student names
		    while (resultSet.next())
		      System.out.println(resultSet.getString(1) + "\t" +
		        resultSet.getString(2) + "\t" + resultSet.getString(3));
		    // Close the connection
		    connection.close();*/
		  }
	@Override
	public void start(Stage arg0) throws Exception{
		window = arg0;
		window.setTitle("Reserve Flights");
		
		//setting background image
		Image reserveImage = new Image("jetblue1.0.jpg");
		ImageView reserveImageView = new ImageView(reserveImage);
		reserveImageView.setPreserveRatio(true);
		reserveImageView.setFitWidth(100);
		Group root = new Group();
		root.getChildren().addAll(reserveImageView);
		
		
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
												backButton,reserveButton,root);
		
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
		
		backButton.setOnAction(e->mainMenu());
		
		Scene scene = new Scene (registrationGrid,400,400);
		window.setScene(scene);
		window.show();
		
	}
	
	private void reservationPage() {
		//window = arg0;
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
		
		backButton.setOnAction(e->mainMenu());
		
		Scene scene = new Scene (registrationGrid,400,400);
		window.setScene(scene);
		window.show();
	}
	private void registrationPage() {
		//window = arg0;
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
		TextField passwordTextField= new TextField();
		TextField securityQuestionTextField= new TextField();
		securityQuestionTextField.setPromptText("Enter your answer to the security question here");
		
		//creating a drop-down list 
		ChoiceBox<String> securityQuestions = new ChoiceBox<>();
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
				mainMenu();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		registerButton.setOnAction(e-> {
			//database code
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
	private void loginPage() {
		//window=arg0;
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
		
		//adding action to button
		backButton.setOnAction(e -> {
			try {
				mainMenu();
			}
			catch(Exception ex) {
				System.out.println("Error going back");
			}
		});
		loginButton.setOnAction(e->{
			//database code
		});
		
		//Creating panes 
		GridPane pane = new GridPane();
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
	
	private void mainMenu() {
		//window =arg0;
		window.setTitle("Main Menu");
		
		//Create two buttons ojects 
		Button login = new Button("Login");
		login.setOnAction(e -> loginPage());
		Button register = new Button("Register");
		register.setOnAction(e -> registrationPage());
		Button recoverPassword = new Button("Forgot Password?");
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
	
	
	/*
	private void videos() {
		window.setTitle("Title here");
		button = new Button("Submit");
		
		//Input and labels
		TextField userInput = new TextField();
		userInput.setMaxWidth(200);
		userInput.setPromptText("Enter Name");
		Label firstLabel = new Label("Welcome to the site: ");
		Label secondLabel = new Label();
		
		HBox bottomText = new HBox();
		bottomText.getChildren().addAll(firstLabel, secondLabel);
		bottomText.setAlignment(Pos.CENTER);
		VBox grid = new VBox(10,userInput,bottomText);
		grid.setAlignment(Pos.CENTER);
		grid.getChildren().addAll(button);
		grid.setPadding(new Insets(10,10,10,10));
		
		secondLabel.textProperty().bind(userInput.textProperty());
		
		Scene scene = new Scene(grid, 300, 200, Color.RED);
		window.setScene(scene);
		window.show();
	}

	
	
	private void video30() { //using binding with FX, enter some input, and some other piece of code changes 
		window.setTitle("Title here");
		button = new Button("Submit");
		
		//Input and labels
		TextField userInput = new TextField();
		userInput.setMaxWidth(200);
		Label firstLabel = new Label("Welcome to the site: ");
		Label secondLabel = new Label();
		
		HBox bottomText = new HBox();
		bottomText.getChildren().addAll(firstLabel, secondLabel);
		bottomText.setAlignment(Pos.CENTER);
		
		VBox grid = new VBox(10,userInput,bottomText);
		grid.setAlignment(Pos.CENTER);
		
		secondLabel.textProperty().bind(userInput.textProperty());
		
		grid.getChildren().addAll(button);
		grid.setPadding(new Insets(10,10,10,10));
		
		
		
		Scene scene = new Scene(grid, 300, 200, Color.RED);
		window.setScene(scene);
		window.show();
	}
	
	private void video29() { // binding two variable together
		window.setTitle("Title here");
		
		IntegerProperty x = new SimpleIntegerProperty(3);
		IntegerProperty y = new SimpleIntegerProperty();
		
		y.bind(x.multiply(10));
		System.out.println(x.getValue());
		System.out.println(y.getValue());
		
		x.setValue(9);
		System.out.println(x.getValue());
		System.out.println(y.getValue());
		

		button = new Button("Submit");
		StackPane grid = new StackPane();		
		grid.getChildren().addAll(button);
		grid.setPadding(new Insets(10,10,10,10));
		Scene scene = new Scene(grid, 300, 200, Color.RED);
		window.setScene(scene);
		window.show();
	}
	
	private void video28() {// adding listeners to strings 
		window.setTitle("Title here");
		
		Person kush = new Person();
		kush.firstNameProperty().addListener((v, oldValue, newValue)-> {
			System.out.println("New Value"+ newValue);
			System.out.println("Object: "+ kush.firstNameProperty());
			System.out.println("Regular String:"+ kush.getFirstName());
		});
		
		button = new Button("Submit");
		button.setOnAction(e -> kush.setFirstName("Raj"));
		StackPane grid = new StackPane();		
		grid.getChildren().addAll(button);
		grid.setPadding(new Insets(10,10,10,10));
		Scene scene = new Scene(grid, 300, 200, Color.RED);
		window.setScene(scene);
		window.show();
	}
	
	private void video27() { // chnaging color 
		window.setTitle("Title here");
		
		
		GridPane grid = new GridPane();
		//grid.setPadding(new Insets(10,10,10,10));
		grid.setVgap(8);
		grid.setHgap(10);
		
		//name Label
		Label nameLabel = new Label("UserName: ");
		GridPane.setConstraints(nameLabel,0,0);
		nameLabel.setStyle("-fx-text-fill: #E8E8E8"); // how to change color of single element
		
		//name input
		TextField nameInput = new TextField("Default text");
		GridPane.setConstraints(nameInput, 1, 0);
		
		//pass label
		Label passLabel = new Label("Password: ");
		GridPane.setConstraints(passLabel,0,1);
		
		//name input
		TextField passInput = new TextField();
		passInput.setPromptText("Password");
		GridPane.setConstraints(passInput, 1, 1);
		
		
		Button login = new Button ("Login");
		GridPane.setConstraints(login, 1, 2);
		
		
		
		grid.getChildren().addAll(nameLabel, nameInput, passLabel, passInput, login);
		grid.setPadding(new Insets(10,10,10,10));
		Scene scene = new Scene(grid, 300, 200, Color.RED);
		window.setScene(scene);
		window.show();

	}
	
	//RadioMenuItems
	private void video24() {
		window.setTitle("Title here");
		
		//file menu 
		Menu fileMenu = new Menu("_File");
		Menu editMenu = new Menu ("_Edit");
		
		//add items to menu
		MenuItem newFile = new MenuItem("New...");	
		newFile.setOnAction(e -> System.out.println("Create a new file..."));
		fileMenu.getItems().add(newFile);
		
		//file menu
		fileMenu.getItems().add(new MenuItem("Open..."));
		fileMenu.getItems().add(new MenuItem("Save..."));
		fileMenu.getItems().add(new SeparatorMenuItem()); // seperators 
		fileMenu.getItems().add(new MenuItem("Settings..."));
		fileMenu.getItems().add(new SeparatorMenuItem());
		fileMenu.getItems().add(new MenuItem("Exit"));
		
		//edit menu
		editMenu.getItems().add(new MenuItem("Cut"));
		editMenu.getItems().add(new MenuItem("Copy"));
		MenuItem paste = new MenuItem ("Paste");
		paste.setOnAction(e -> System.out.println("Pasting something"));
		editMenu.getItems().add(paste);
		paste.setDisable(true);
		
		//Help Menu
		Menu helpMenu = new Menu("_Help");
		CheckMenuItem showLines = new CheckMenuItem("Show Line Numbers");
		showLines.setOnAction(e -> {
			if(showLines.isSelected()) {
				System.out.println("Program will now display line numbers");
			}
			else {
				System.out.println("Hiding line numbers");
			}
		});
		
		CheckMenuItem autoSave = new CheckMenuItem("Enable Autosave");
		autoSave.setSelected(true);
		helpMenu.getItems().addAll(showLines,autoSave);
		
		//RadioButton
		Menu difficultlyMenu = new Menu("Difficulty");
		ToggleGroup difficultyToggle = new ToggleGroup();
		
		RadioMenuItem easy = new RadioMenuItem("Easy");
		RadioMenuItem medium = new RadioMenuItem("Medium");
		RadioMenuItem hard = new RadioMenuItem("Hard");
		
		easy.setToggleGroup(difficultyToggle);
		medium.setToggleGroup(difficultyToggle);
		hard.setToggleGroup(difficultyToggle);
		
		difficultlyMenu.getItems().addAll(easy,medium,hard);
		
		
		//add menu and items to menu bar
		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().addAll(fileMenu,editMenu,helpMenu, difficultlyMenu);
		
		layout= new BorderPane();
		layout.setTop(menuBar);
		scene = new Scene (layout, 400, 300);
		window.setScene(scene);
		window.show();
	}
	
	private void video23() { //CheckMenuItem class 
		window.setTitle("Title here");
		
		//file menu 
		Menu fileMenu = new Menu("_File");
		Menu editMenu = new Menu ("_Edit");
		
		//add items to menu
		MenuItem newFile = new MenuItem("New...");	
		newFile.setOnAction(e -> System.out.println("Create a new file..."));
		fileMenu.getItems().add(newFile);
		
		//file menu
		fileMenu.getItems().add(new MenuItem("Open..."));
		fileMenu.getItems().add(new MenuItem("Save..."));
		fileMenu.getItems().add(new SeparatorMenuItem()); // seperators 
		fileMenu.getItems().add(new MenuItem("Settings..."));
		fileMenu.getItems().add(new SeparatorMenuItem());
		fileMenu.getItems().add(new MenuItem("Exit"));
		
		//edit menu
		editMenu.getItems().add(new MenuItem("Cut"));
		editMenu.getItems().add(new MenuItem("Copy"));
		MenuItem paste = new MenuItem ("Paste");
		paste.setOnAction(e -> System.out.println("Pasting something"));
		editMenu.getItems().add(paste);
		paste.setDisable(true);
		
		//Help Menu
		Menu helpMenu = new Menu("_Help");
		CheckMenuItem showLines = new CheckMenuItem("Show Line Numbers");
		showLines.setOnAction(e -> {
			if(showLines.isSelected()) {
				System.out.println("Program will now display line numbers");
			}
			else {
				System.out.println("Hiding line numbers");
			}
		});
		
		CheckMenuItem autoSave = new CheckMenuItem("Enable Autosave");
		autoSave.setSelected(true);
		helpMenu.getItems().addAll(showLines,autoSave);
		
		
		//add menu and items to menu bar
		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().addAll(fileMenu,editMenu,helpMenu);
		
		layout= new BorderPane();
		layout.setTop(menuBar);
		scene = new Scene (layout, 400, 300);
		window.setScene(scene);
		window.show();
	}
	
	//make do thing when menu item clicked, seperators in menu items, disable item
	private void video22() {
		window.setTitle("Title here");
		
		//file menu 
		Menu fileMenu = new Menu("_File");
		Menu editMenu = new Menu ("_Edit");
		
		//add items to menu
		MenuItem newFile = new MenuItem("New...");	
		newFile.setOnAction(e -> System.out.println("Create a new file..."));
		fileMenu.getItems().add(newFile);
		
		fileMenu.getItems().add(new MenuItem("Open..."));
		fileMenu.getItems().add(new MenuItem("Save..."));
		fileMenu.getItems().add(new SeparatorMenuItem());
		fileMenu.getItems().add(new MenuItem("Settings..."));
		fileMenu.getItems().add(new SeparatorMenuItem());
		fileMenu.getItems().add(new MenuItem("Exit"));
		
		editMenu.getItems().add(new MenuItem("Cut"));
		editMenu.getItems().add(new MenuItem("Copy"));
		
		MenuItem paste = new MenuItem ("Paste");
		paste.setOnAction(e -> System.out.println("Pasting something"));
		editMenu.getItems().add(paste);
		paste.setDisable(true);
	
		
		//add menu and items to menu bar
		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().addAll(fileMenu,editMenu);
		
		layout= new BorderPane();
		layout.setTop(menuBar);
		scene = new Scene (layout, 400, 300);
		window.setScene(scene);
		window.show();

	}
	
	//make menu 
	private void video21() {
		window.setTitle("Title here");
		
		//file menu 
		Menu fileMenu = new Menu("File");
		
		//add items to menu
		fileMenu.getItems().add(new MenuItem("New Project..."));
		fileMenu.getItems().add(new MenuItem("New Module..."));
		fileMenu.getItems().add(new MenuItem("Import Project..."));
		
		//add menu and items to menu bar
		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().addAll(fileMenu);
		
		layout= new BorderPane();
		layout.setTop(menuBar);
		scene = new Scene (layout, 400, 300);
		window.setScene(scene);
		window.show();
	}
	
	//add and delete items from table using interactive buttons
	private void video20() { 
		window.setTitle("Title here");
		
		//Name Column
		TableColumn<Products, String> nameColumn = new TableColumn<>("Name");
		nameColumn.setMinWidth(200);
		PropertyValueFactory<Products, String> temp = new PropertyValueFactory<>("name");
		nameColumn.setCellValueFactory(temp);
		
		TableColumn<Products, Double> priceColumn = new TableColumn<>("Price");
		priceColumn.setMinWidth(100);
		priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));		
		
		TableColumn<Products, Integer> quantityColumn = new TableColumn<>("Quantity");
		quantityColumn.setMinWidth(200);
		quantityColumn.setCellValueFactory(new PropertyValueFactory<>("inventory"));
		
		//making input 
		nameInput= new TextField();
		nameInput.setPromptText("Name");
		nameInput.setMinWidth(100);
		
		priceInput= new TextField();
		priceInput.setPromptText("Price");
		priceInput.setMinWidth(100);
		
		quantityInput= new TextField();
		quantityInput.setPromptText("Quantity");
		quantityInput.setMinWidth(100);
		
		//Add buttons
		Button addButton = new Button("Add item");
		addButton.setOnAction(e -> addButtonClicked());
		
		Button deleteButton = new Button("Delete item");
		deleteButton.setOnAction(e-> deleteButtonClicked());
		
		
		HBox hbox = new HBox();
		hbox.setPadding(new Insets(10,10,10,10));
		hbox.setSpacing(10);
		hbox.getChildren().addAll(nameInput,priceInput,quantityInput,addButton,deleteButton);
		
		table = new TableView();
		table.setItems(getProduct());
		table.getColumns().addAll(nameColumn,priceColumn,quantityColumn);
		
		VBox layout = new VBox();
		layout.getChildren().addAll(table,hbox);
		
		scene = new Scene (layout, 200, 200);
		window.setScene(scene);
		window.show();
	}
	//video 20 
	private void addButtonClicked() {
		Products temp = new Products();
		temp.setName(nameInput.getText());
		temp.setPrice(Double.parseDouble(priceInput.getText()));
		temp.setInventory(Integer.parseInt(quantityInput.getText()));
		table.getItems().add(temp);
		
		nameInput.clear();
		priceInput.clear();
		quantityInput.clear();
		
	}
	//video 20
	private void deleteButtonClicked() {
		ObservableList<Products> productSelected, allProducts;
		allProducts = table.getItems();
		productSelected = table.getSelectionModel().getSelectedItems();
		
		productSelected.forEach(allProducts::remove);
	}
	
	private void video19() {
		window.setTitle("Title here");
		
		//Name Column
		TableColumn<Products, String> nameColumn = new TableColumn<>("Name");
		nameColumn.setMinWidth(200);
		PropertyValueFactory<Products, String> temp = new PropertyValueFactory<>("name");
		nameColumn.setCellValueFactory(temp);
		
		TableColumn<Products, Double> priceColumn = new TableColumn<>("Price");
		priceColumn.setMinWidth(100);
		priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));		
		
		TableColumn<Products, Integer> quantityColumn = new TableColumn<>("Quantity");
		quantityColumn.setMinWidth(200);
		quantityColumn.setCellValueFactory(new PropertyValueFactory<>("inventory"));
		
		//making input 
		nameInput= new TextField();
		nameInput.setPromptText("Name");
		nameInput.setMinWidth(100);
		
		priceInput= new TextField();
		priceInput.setPromptText("Price");
		priceInput.setMinWidth(100);
		
		quantityInput= new TextField();
		quantityInput.setPromptText("Quantity");
		quantityInput.setMinWidth(100);
		
		//Add buttons
		Button addButton = new Button("Add item");
		Button deleteButton = new Button("Delete item");
		
		
		HBox hbox = new HBox();
		hbox.setPadding(new Insets(10,10,10,10));
		hbox.setSpacing(10);
		hbox.getChildren().addAll(nameInput,priceInput,quantityInput,addButton,deleteButton);
		
		table = new TableView();
		table.setItems(getProduct());
		table.getColumns().addAll(nameColumn,priceColumn,quantityColumn);
		
		VBox layout = new VBox();
		layout.getChildren().addAll(table,hbox);
		
		scene = new Scene (layout, 200, 200);
		window.setScene(scene);
		window.show();
	}
	
	private void video18() {
		window.setTitle("Title here");
		button = new Button ("Order Now");
		
		//Name Column
		TableColumn<Products, String> nameColumn = new TableColumn<>("Name");
		nameColumn.setMinWidth(200);
		PropertyValueFactory<Products, String> temp = new PropertyValueFactory<>("name");
		nameColumn.setCellValueFactory(temp);
		TableColumn<Products, Double> priceColumn = new TableColumn<>("Price"); //This is what you want to name the column so anythhing
		priceColumn.setMinWidth(100);
		priceColumn.setCellValueFactory(new PropertyValueFactory<>("price")); // This must match the variable name in Products class	
		TableColumn<Products, Integer> quantityColumn = new TableColumn<>("Quantity");
		quantityColumn.setMinWidth(200);
		quantityColumn.setCellValueFactory(new PropertyValueFactory<>("inventory"));
		
		table = new TableView();
		table.setItems(getProduct());
		table.getColumns().addAll(nameColumn,priceColumn,quantityColumn);
		
		VBox layout = new VBox();
		layout.getChildren().addAll(table);
		
		scene = new Scene (layout, 200, 200);
		window.setScene(scene);
		window.show();
	}
	
	//Video 18 making simple table view
	private ObservableList<Products> getProduct(){
		ObservableList<Products> products = FXCollections.observableArrayList();
		products.add(new Products("Apple", 2.99, 100));
		products.add(new Products("Banana", 1.99, 110));
		products.add(new Products("Cherry", 0.99, 130));
		products.add(new Products("Strawberry", 1.59, 120));
		products.add(new Products("Laptop", 1299.99, 10));
		
		return products;
		
	}
	
	
	private void video16() {
		window.setTitle("Title here");
		button = new Button ("Order Now");
		
		TreeItem <String> root, kush, patel;
		//root 
		root = new TreeItem<>();
		root.setExpanded(true);
		
		//Kush
		kush = makeBranch("Kush", root);
		makeBranch("Computers", kush);
		makeBranch("Java", kush);
		makeBranch("Programing", kush);
		
		
		
		//Patel
		
		patel = makeBranch("Patel", root);
		makeBranch("Last", patel);
		makeBranch("Week", patel);
		makeBranch("School", patel);
		
		tree= new TreeView<>(root);
		tree.setShowRoot(false);
		tree.getSelectionModel().selectedItemProperty().addListener((v, oldItem, newItem)-> {
			if(newItem != null)
				System.out.println(newItem.getValue());
		});
		
		StackPane layout = new StackPane();
		layout.getChildren().addAll(tree);	
		scene = new Scene (layout, 200, 200);
		window.setScene(scene);
		window.show();
	}
	//video 16
	private TreeItem<String> makeBranch(String title, TreeItem<String> parent){
		TreeItem<String> item = new TreeItem<>(title);
		item.setExpanded(true);
		parent.getChildren().add(item);
		return item;
	}
	
	private void video15() { //Lisy view, like a drop down but select multiple
		window.setTitle("Title here");
		button = new Button ("Order Now");
	
		listview = new ListView();
		listview.getItems().addAll("Ironman", "Superman", "Batman");
		listview.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		
		button.setOnAction(e -> buttonClick());
		
		VBox layout = new VBox(10);
		layout.setPadding(new Insets(20,20,20,20));
		layout.getChildren().addAll(listview,button);
		
		scene = new Scene (layout, 200, 200);
		window.setScene(scene);
		window.show();
	}
	//video 15
	private void buttonClick() {
		String message = "";
		ObservableList<String> superheros;
		superheros = listview.getSelectionModel().getSelectedItems();
		
		for (String m: superheros) {
			message += m +"\n";
		}
		
		System.out.println(message);
	}
	private void video14() { //dropdown but lets you enter your choices
		window.setTitle("Title here");
		button = new Button ("Order Now");
	
		combobox = new ComboBox<>();
		combobox.getItems().addAll(
				"Kush",
				"Patel",
				"Mahesh"
				);
		
		combobox.setPromptText("What is your first Name");
		combobox.setEditable(true);
		button.setOnAction(e -> printName());
		
		combobox.setOnAction(e -> System.out.println("User selected: "+combobox.getValue()));
		combobox.setValue("Kush");
		VBox layout = new VBox(10);
		layout.setPadding(new Insets(20,20,20,20));
		layout.getChildren().addAll(combobox,button);
		
		scene = new Scene (layout, 200, 200);
		window.setScene(scene);
		window.show();
	}
	//video 14
	private void printName() {
		System.out.println(combobox.getValue());
	}
	
	private void video13() {
		window.setTitle("Title here");
		Button button = new Button ("Order Now");
	
		ChoiceBox <String> choiceBox = new ChoiceBox<>();
		
		choiceBox.getItems().add("Apples");
		choiceBox.getItems().add("Bananas");
		choiceBox.getItems().addAll("Oranges", "Strawberries");
		choiceBox.setValue("Apples"); // default value has to be something that exist in your list
		
		
		//Listen for selection changes
		choiceBox.getSelectionModel().selectedItemProperty().addListener( (v, oldValue, newValue) -> System.out.println(newValue));
	
		VBox layout = new VBox(10);
		layout.setPadding(new Insets(20,20,20,20));
		layout.getChildren().addAll(choiceBox,button);
		
		scene = new Scene (layout, 200, 200);
		window.setScene(scene);
		window.show();
	}
	
	//Video 12 making checkboxes  
	private void getChoice(ChoiceBox <String> c1) {
		String food = c1.getValue();
		System.out.println(food);
	}
	private void video12() {
		window.setTitle("Title here");
		Button button = new Button ("Order Now");
	
		ChoiceBox <String> choiceBox = new ChoiceBox<>();
		
		choiceBox.getItems().add("Apples");
		choiceBox.getItems().add("Bananas");
		choiceBox.getItems().addAll("Oranges", "Strawberries");
		
		choiceBox.setValue("Apples"); // default value has to be something that exist in your list
		
		button.setOnAction(e -> getChoice(choiceBox));
		VBox layout = new VBox(10);
		layout.setPadding(new Insets(20,20,20,20));
		layout.getChildren().addAll(choiceBox,button);
		
		Scene scene = new Scene (layout, 200, 200);
		window.setScene(scene);
		window.show();
	}
	
	//video 11 Printing out in the console depening on what is selected
	private void handleOptions(CheckBox b1, CheckBox b2) {
		String message="User Order:\n";
		if(b1.isSelected()) {
			message += "Option 1\n";
		}
		if(b2.isSelected()) {
			message += "Option 2\n";
		}
		
		System.out.println(message);
	}
	
	
	//video 10
	private boolean isInt(TextField input, String message) {
		try {
			int age = Integer.parseInt(input.getText());
			System.out.println("User is: "+ age);
			return true;
		}catch(NumberFormatException e) {
			System.out.println("Error: "+ message + " is not a number");
			return false; 
		}
		
	}
	
	//video 7
	private void closeProgram() {
		Boolean answer = ConfirmBox.display("Title", "Sure you want to exit?");
		if (answer) {
			window.close();
		}
	}
/*from first 3-4 videos
	Button button;
	@Override
	public void start(Stage arg0) throws Exception {
		arg0.setTitle("Title of the Window");
		button = new Button("Click me"); //Can put text on button when initilizing 
		//button.setText("Click me"); //this is how you can put text on a button
		//Method below tells the button what action to do when clicked. Take the eclipse to handle() emthod
		button.setOnAction(e -> {
			System.out.println("Hey now");
			System.out.println("This is how you print out multiple lines by clicking a button");
			});
		
		StackPane layout = new StackPane();
		layout.getChildren().add(button);
		
		Scene scene = new Scene(layout,300, 250);
		arg0.setScene(scene);
		arg0.show();
	}


*/
/* deleted stuff
	@Override
	public void handle(ActionEvent arg0) {
		//This is so we know which button called the method, so different action for different method
		if(arg0.getSource()==button) {
			System.out.println("Good Job");
		}	
	}

	
video 8 making complex windows, with button at top and side
 	public void start(Stage arg0) throws Exception{
		window = arg0;
		window.setTitle("Title here");
		
		HBox topMenu = new HBox();
		Button a = new Button("File");
		Button b = new Button("View");
		Button c = new Button("Edit");
		topMenu.getChildren().addAll(a,b,c);
		
		VBox leftMenu = new VBox();
		Button d = new Button("D");
		Button e = new Button("E");
		Button f = new Button("F");
		leftMenu.getChildren().addAll(d,e,f);
		
		
		BorderPane borderPane = new BorderPane();
		borderPane.setTop(topMenu);
		borderPane.setLeft(leftMenu);
		
		scene = new Scene(borderPane, 200, 200);
		window.setScene(scene);
		window.show();
		
	}



	
Video 9
 public void start(Stage arg0) throws Exception{
		window = arg0;
		window.setTitle("Title here");
		
		GridPane grid = new GridPane();
		//grid.setPadding(new Insets(10,10,10,10));
		grid.setVgap(8);
		grid.setHgap(10);
		
		//name Label
		Label nameLabel = new Label("UserName: ");
		GridPane.setConstraints(nameLabel,0,0);
		
		//name input
		TextField nameInput = new TextField("Default text");
		GridPane.setConstraints(nameInput, 1, 0);
		
		//pass label
		Label passLabel = new Label("Password: ");
		GridPane.setConstraints(passLabel,0,1);
		
		//name input
		TextField passInput = new TextField();
		passInput.setPromptText("Password");
		GridPane.setConstraints(passInput, 1, 1);
		
		
		Button login = new Button ("Login");
		GridPane.setConstraints(login, 1, 2);
		
		grid.getChildren().addAll(nameLabel, nameInput, passLabel, passInput, login);
		Scene scene = new Scene(grid, 300, 200);
		
		window.setScene(scene);
		window.show();
		
	}
 
	*/

}
