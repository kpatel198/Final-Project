
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

//Still in progress
public class Customer{

	public static void main(String[] args) throws Exception {

		createCustTable();
		post();
		getSecurityQandA();
	}

	public static void createCustTable()throws Exception{
		try{
			Connection con = getConnection();
			PreparedStatement create  = con.prepareStatement("CREATE TABLE IF NOT EXISTS customer(id int NOT NULL AUTO_INCREMENT, first varchar(255)NOT NULL, last varchar(255)NOT NULL, address varchar(255)NOT NULL,zip varchar(5)NOT NULL, state varchar(255)NOT NULL, username varchar(255)NOT NULL, password varchar(255)NOT NULL, ssn varchar(11)NOT NULL, securityqu varchar(255)NOT NULL, securityan varchar(255)NOT NULL ,PRIMARY KEY(id))");
			create.executeUpdate();

		}catch(Exception e) {System.out.println(e);}
		finally {System.out.println("Table created.");}
	}

	//Inserts statements into customer table
	String firstName = "Jane";
String secondName = "Smith";
String address = "Rose St";
String state = "CA";
String zip= "90012";
String username = "jsmith";
String password = "password";
String ssn = "001-03-0010";
String securityAnswer = "0001";
String securityQuestion = "What were the last four digits of your childhood telephone number?";

try {
	Connection con = getConnection();
	PreparedStatement posted = con.prepareStatement("INSERT INTO customer (first, last, address, zip, state, username, password, ssn, securityqu, securityan) VALUES ('"+ firstName+ "','"+secondName+"','"+address+"','"+zip+"','"+state+"','"+username+"','"+password+"','"+ssn+"','"+securityQuestion+"', '"+securityAnswer+"')");
	posted.executeUpdate();
}catch (Exception e) {System.out.println(e);}
finally {
	System.out.println("Insert Completed.");
}

}


	//Retrieves security question and answer for password recovery. Stores in array
	public static ArrayList<String> getSecurityQandA() throws Exception {
		try {
			Connection con = getConnection();
			PreparedStatement recover = con.prepareStatement("SELECT securityqu, securityans FROM customer WHERE username like ?");

			ResultSet result = recover.executeQuery();

			ArrayList<String> array = new ArrayList<String>();
			while(result.next()) {
				//Needs to print on customer visual
				System.out.print(result.getString("securityqu"));

				array.add(result.getString(("securityqu, securityans")));
			}
			System.out.println("All records have been selected.");
			return array;

		}catch(Exception e) {System.out.println(e);}
		return null;

	}

	//establishes connection to database
	public static Connection getConnection () throws Exception {
		try {
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://35.196.232.95:3306/test";
			String username = "root";
			String password = "";
			Class.forName(driver);

			Connection conn = DriverManager.getConnection(url, username,password);
			System.out.println("Connected");
			return conn;
		} catch(Exception e) {System.out.println(e);}

		return null;
	}


}
