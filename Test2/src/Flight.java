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
			PreparedStatement create  = con.prepareStatement("CREATE TABLE IF NOT EXISTS flight(number varchar(255) NOT NULL, fromCity varchar(255) NOT NULL, toCity varchar(255)NOT NULL, date varchar(255)NOT NULL,time varchar(5)NOT NULL, seats int,PRIMARY KEY(number))");
			create.executeUpdate();

		}catch(Exception e) {System.out.println(e);}
		finally {System.out.println("Table created.");}
	}

	//Adds flight to flight table
	public static void postFlight() throws Exception{
			final String fromCity = "DAL";
			final String toCity = "ATL";
			final String dateFrom = "2020-05-23";
			final String time = "04:00";

				try {
						Connection con = getConnection();
						PreparedStatement posted = con.prepareStatement("INSERT INTO flight (fromCity, toCity, date, time) VALUES ('"+ fromCity+ "','"+toCity+"','"+dateFrom+"','"+time+"')");
				posted.executeUpdate();
			}catch (Exception e) {System.out.println(e);}
			finally {
				System.out.println("Insert Completed.");
			}

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
