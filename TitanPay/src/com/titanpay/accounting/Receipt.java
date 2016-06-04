package com.titanpay.accounting;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class Receipt {
	
	private DateTime date;
	private double saleAmt;
	
	public Receipt(String date, double saleAmt){
		DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyyMMdd-HH:mm");
		this.date = DateTime.parse(date, formatter);
		//Turning the inputed string into a Date we can use.
		this.saleAmt = saleAmt;  
	}
	@Override
	public String toString(){
		String theString = "Receipt :\tDate: "+this.date+"\tSale Amount: "+this.saleAmt;
		return theString;
	}
}
