package com.titanpay.accounting;

import java.sql.Time;
import java.util.Calendar;


public class TimeCard {
	private String date;
	private double startTime;
	private double endTime;
	
	public double calculateDailyPay(double rate){
		double hoursWorked  = 10;//this.endTime - this.startTime;
		double overtime = 0;
		double pay = 0;
		double overtimePay;
		
		if (hoursWorked>8){
			overtime = hoursWorked - 8;		
			overtimePay = overtime * (rate * 1.5);
			pay = overtimePay+(rate*8); 
			return pay;
		}
		pay = hoursWorked * rate;
		return pay;
	}
}
