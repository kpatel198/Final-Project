
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
			PreparedStatement create  = con.prepareStatement("CREATE TABLE IF NOT EXISTS customer(id int NOT NULL AUTO_INCREMENT, first varchar(255), last varchar(255), address varchar(255),zip int(5), state varchar(255), username varchar(255), password varchar(255), ssn varchar(11), securityqu varchar(255), securityan varchar(255) ,PRIMARY KEY(id))");
			create.executeUpdate();

		}catch(Exception e) {System.out.println(e);}
		finally {System.out.println("Table created.");}
	}

	//Inserts statements into customer table **NEEDS TO COME FROM TEXT FIELD
	public static void post() throws Exception{
		final String VAR1 = firstNameTextField;
		final String VAR2 = secondNameTextField;
		final String VAR3 = addressTextField1;
		final String VAR4 = addressTextField2;
		final String VAR5 = cityTextField;
		final String VAR6 = stateTextField;
		final String VAR7 = zipcodeTextField;
		final String VAR8 = usernameTextField;
		final String VAR9 = passwordTextField;
		final String VAR10 = ssnTextField;

		try {
			Connection con = getConnection();
			PreparedStatement posted = con.prepareStatement("INSERT INTO customer (first, last, address, zip, state, username, password, ssn) VALUES ('"+ VAR1+ "','"+VAR2+"','"+VAR3+"','"+VAR4+"','"+VAR5+"','"+VAR6+"','"+VAR7+"','"+VAR8+"','"+VAR9+"','"+VAR10+"')");
			posted.executeUpdate();
		}catch (Exception e) {System.out.println(e);}
		finally {
			System.out.println("Insert Completed.");
		}

	}

	//Retrieves security question and answer for password recovery. Stores in array **NEEDS TO CROSS REF USERNAME
	public static ArrayList<String> getSecurityQandA() throws Exception {
		try {
			Connection con = getConnection();
			PreparedStatement recover = con.prepareStatement("SELECT securityqu, securityans FROM customer");

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
