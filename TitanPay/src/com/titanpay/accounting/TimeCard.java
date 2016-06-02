package com.titanpay.accounting;


import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.joda.time.Interval;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class TimeCard {
	private DateTime date;
	private DateTime startTime;
	private DateTime endTime;

	public TimeCard(String startTime , String endTime ){
		// Take incoming strings and make them useful Date objects
		DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyyMMdd-HH:mm");
		this.startTime = DateTime.parse(startTime, formatter);
		this.endTime = DateTime.parse(endTime, formatter);
		
		this.date = new DateTime();
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
}
