package application;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
	
	public static void main(String [] args) throws Exception {
		
		getConnection();
		
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
	
	public static void newCustomer() {
		//adding database code from registration page 
		//Problem: accessing all the variables, maybe just make them arguments 
			
	}
	
	public static void deleteCustomer() {
		
	}
	
	public static void addFlight() {
		
	}
	
	public static void delteFlight() {
		
	}
	
	
	
}
