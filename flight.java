package application;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class Flight {
	

	private String flightNum;
	private String toCity;
	private String fromCity;
	private String date;
	private String time;
	private String seats;
	private static ArrayList<Flight> newflight;
	
	
	public Flight() {
		this.flightNum = "";
		this.toCity =  "";
		this.fromCity = "";
		this.date = "";
		this.time ="";
		this.seats ="";
	}
	
	public Flight(String flightNum ,String toCity, String fromCity, String date,String time, String seats) {
		this.flightNum = flightNum;
		this.toCity = toCity;
		this.fromCity = fromCity;
		this.date = date;
		this.time = time;
		this.seats = seats;
	}
	
	public String getFlightNum() {
		return flightNum;
	}
	public void setFlightNum(String flightNum) {
		this.flightNum = flightNum;
	}
	public String gettoCity() {
		return toCity;
	}
	public void settoCity(String toCity) {
		this.toCity=toCity;
	}
	public String getfromCity() {
		return fromCity;
	}
	public void setfromCity(String fromCity) {
		this.fromCity=fromCity;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getSeats() {
		return seats;
	}
	public void setSeats(String seats) {
		this.seats = seats;
	}
}
