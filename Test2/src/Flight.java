import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Flight {

public static void main(String[] args) throws Exception  {

		createFlightTable();
		postFlight();
	}

//Creates flight table in SQL database
	public static void createFlightTable()throws Exception{
		try{
			Connection con = getConnection();
			PreparedStatement create  = con.prepareStatement("CREATE TABLE IF NOT EXISTS flight(number int NOT NULL, fromCity varchar(255), toCity varchar(255), date date,time time, seats int,PRIMARY KEY(number))");
			create.executeUpdate();

		}catch(Exception e) {System.out.println(e);}
		finally {System.out.println("Table created.");}
	}

	//Inserts statements into flight table **NEEDS TO COME FROM GUI
public static void postFlight() throws Exception{
	final String VAR1 = number.getText();
	final String VAR2 = toCity.getText();
	final String VAR3 = fromCity.getText();
	final String VAR4 = date.getText();
	final String VAR5 = time.getText();
	final String VAR6 = seats.getText();

	try {
			Connection con = getConnection();
			PreparedStatement posted = con.prepareStatement("INSERT INTO flight (number, fromCity, toCity, date, time, seats) VALUES ('"+ VAR1+ "','"+VAR2+"','"+VAR3+"','"+VAR4+"','"+VAR5+"','"+VAR6+"')");
			posted.executeUpdate();
		}catch (Exception e) {System.out.println(e);}
		finally {
			System.out.println("Insert Completed.");
		}

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
