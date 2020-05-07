package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Database {
	
	public static void main(String [] args) throws Exception {
		
		getConnection();
		createCustTable();
		createFlightTable();
		flight1();
		
		
	}

	//connect to database
	public static Connection getConnection() throws Exception{
		try {
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://35.196.232.95:3306/test";
			String username = "root";
			String password = "";
			Class.forName(driver);
			
			Connection conn = DriverManager.getConnection(url,username,password);
			System.out.println("Connected");
			return conn;
		} catch(Exception e) {System.out.println(e);}
		
		return null;
		
	}
	
	//create table "customer" in database
	public static void createCustTable()throws Exception{
		try{
			Connection conn = getConnection();
			PreparedStatement create  = conn.prepareStatement("CREATE TABLE IF NOT EXISTS customer(id int NOT NULL AUTO_INCREMENT, first varchar(255), last varchar(255), address varchar(255),zip int(5), state varchar(255), username varchar(255), password varchar(255), ssn varchar(11), securityqu varchar(255), securityan varchar(255) ,PRIMARY KEY(id))");
			create.executeUpdate();

		}catch(Exception e) {System.out.println(e);}
		finally {System.out.println("Customer table created.");}
	}

	
	
	//create table "flight" in database
		public static void createFlightTable()throws Exception{
			try{
				Connection conn = getConnection();
				PreparedStatement create  = conn.prepareStatement("CREATE TABLE IF NOT EXISTS flight(flightNum varchar(255) NOT NULL, fromCity varchar(255) NOT NULL, toCity varchar(255)NOT NULL, date varchar(255)NOT NULL,time varchar(5)NOT NULL, seats int,PRIMARY KEY(flightNum))");
				create.executeUpdate();

			}catch(Exception e) {System.out.println(e);}
			finally {System.out.println("Flight table created.");}
		}
		
		//Inserts into flight table
		public static void flight1() throws Exception{
			final String fromCity = "DAL";
			final String toCity = "ATL";
			final String dateFrom = "05-23-2020";
			final String time = "04:00";
			final String flightNum = "110";

				try {
						Connection con = getConnection();
						PreparedStatement posted = con.prepareStatement("INSERT INTO flight (flightNum, fromCity, toCity, date, time) VALUES ('"+ flightNum +"','"+ fromCity+ "','"+toCity+"','"+dateFrom+"','"+time+"')");
				posted.executeUpdate();
			}catch (Exception e) {System.out.println(e);}
			finally {
				System.out.println("Insert Completed.");
			}

		}
		
		
		
	
}
