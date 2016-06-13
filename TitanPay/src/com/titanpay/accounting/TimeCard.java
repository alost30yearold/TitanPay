package com.titanpay.accounting;


import org.joda.time.DateTime;
import org.joda.time.DateTime.Property;
import org.joda.time.Duration;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class TimeCard {
	private DateTime date;
	private DateTime startTime;
	private DateTime endTime;
	private int day;
	//private int startedTime;
	//private int endedTime;
	
	public TimeCard(){
		// Take incoming strings and make them useful Date objects
		//DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyyMMdd-HH:mm");
		//this.date = new DateTime();
		//this.startedTime = date.getHourOfDay();
		//this.day = date.getDayOfMonth();	
		this.startTime = DateTime.now();
		this.endTime = DateTime.now();
		this.date = startTime;
		
	}
	public TimeCard(DateTime startTime,DateTime endTime){
		this.startTime = startTime;
		this.endTime = endTime;
		this.date = DateTime.now();
		
	}
	public TimeCard(DateTime startTime){
		this.startTime = startTime;
		this.date = startTime;//DateTime.now();	
		
	}
	public TimeCard(String startTime , String endTime ){
		// Take incoming strings and make them useful Date objects
		DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyyMMdd-HH:mm");
		this.startTime = DateTime.parse(startTime, formatter);
		this.endTime = DateTime.parse(endTime, formatter);
		
		this.date = this.startTime;
	}
	public TimeCard(String startTime , String endTime, String date ){
		// Take incoming strings and make them useful Date objects
		DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyyMMdd-HH:mm");
		this.startTime = DateTime.parse(startTime, formatter);
		this.endTime = DateTime.parse(endTime, formatter);
		this.date = DateTime.parse(date, formatter);

	}
	
	public double calculateDailyPay(double rate){
		Duration normalWorkDay = Duration.standardHours(8); // standard 8 hour work day
		Duration hoursWorked = new Duration(startTime,endTime);//finding hours worked.
		int workedHours = (int) hoursWorked.getStandardHours();
		double overtimePay = 0;
		
		if (hoursWorked.isLongerThan(normalWorkDay)){//Math to find out pay.
			int overtime = workedHours - 8;		
			overtimePay = overtime * (rate * 1.5);
			workedHours =8;
		}
		double regularPay = workedHours * rate;
		double pay = regularPay + overtimePay;
		return pay;
	}
	@Override
	public String toString(){
		String theString = "Time Card :\tDate: " +this.date+"\tStarted work: "+this.startTime+"\tEnded Work: "+this.endTime;
		return theString;
	}
	
	public int getDateOfMonth() {
		return date.getDayOfMonth();
	}
	public void setDate(DateTime date) {
		this.date = date;
	}
	public DateTime getStartTime() {
		return startTime;
	}
	public void setStartTime(DateTime startTime) {
		this.startTime = startTime;
	}
	public DateTime getEndTime() {
		return endTime;
	}
	public void setEndTime(DateTime endTime) {
		this.endTime = endTime;
	}

}
