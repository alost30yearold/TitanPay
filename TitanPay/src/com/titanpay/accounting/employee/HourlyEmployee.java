package com.titanpay.accounting.employee;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import com.titanpay.payapp.TimeCard;

public class HourlyEmployee extends Employee implements Payable {
	
	private double hourlyRate;
	private ArrayList<TimeCard> timeCards = new ArrayList<TimeCard>();
	
	public HourlyEmployee(){
		
	}

	public HourlyEmployee(int employeeId, String firstName, String lastName, double weeklyDues, double hourlyRate, Address address,PaymentMethod payMethod) {
		super(employeeId, firstName, lastName, weeklyDues, address, payMethod);
		timeCards = new ArrayList<TimeCard>();
		this.hourlyRate = hourlyRate;

	}
	public HourlyEmployee(String firstName, String lastName) {
		super(firstName, lastName);
		
	}

	public void clockIn(){
		TimeCard clockedIn = new TimeCard(DateTime.now());
		timeCards.ensureCapacity(31);
		timeCards.add(clockedIn);
		//System.out.println("Clocked in at "+clockedIn);
	}
	public void clockIn(TimeCard time){
		TimeCard clockedIn = time;
		timeCards.ensureCapacity(31);
		timeCards.add(clockedIn);
		//System.out.println("Clocked in at "+clockedIn);
	}
	public void clockOut(){
		DateTime currentDay = new DateTime();
		for (TimeCard t : timeCards){
			
			if(t.getDayOfYear() == currentDay.getDayOfYear() && t.getYear() == currentDay.getYear() ){
	
				TimeCard clockedOut = t;
				clockedOut.setEndTime(DateTime.now());
				//System.out.println("Clocked out at "+clockedOut);

			}
		}	
	}
	//May not work yet   v
	public void clockOut(TimeCard time){
		DateTime currentDay = time.getEndTime();
		for (TimeCard t : timeCards){
			
			if(t.getDayOfYear() == currentDay.getDayOfYear() ){
	
				TimeCard clockedOut = t;
				clockedOut.setEndTime(time.getEndTime());
				//System.out.println("Clocked out at "+clockedOut);

			}
		}	
	}
	public void setTimeCardsArray(List<TimeCard> timeCard){
	this.timeCards = (ArrayList<TimeCard>) timeCard;
		
		
	}
	public void addTimeCard(TimeCard addd){
		timeCards.add(addd);

	}
	
	@Override
	public void pay(String startDate, String endDate) {
		// Take incoming strings and make them useful Date objects
		DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyyMMdd-HH:mm");
		DateTime startedDate = DateTime.parse(startDate, formatter);
		DateTime endedDate = DateTime.parse(endDate, formatter);
		double paySum=0;
		for(TimeCard t : timeCards){
					
			if(t.getDayOfYear() >= startedDate.getDayOfYear() && t.getDayOfYear() <= endedDate.getDayOfYear() && t.getYear() >= startedDate.getYear() && t.getYear() <= endedDate.getYear()){
			paySum += t.calculateDailyPay(hourlyRate);
			
			}
		}
		//return paySum;
		//this.getPayMethod().pay(this.getFullNameFL(), paySum);
		this.getPayMethod().pay(this.getFullNameFL(), paySum);
	}
	
	@Override
	public String toString(){
		String theString = "Hourly fEmployee :"+this.getFullNameFL()+"\tHourly Rate: "+this.hourlyRate;
		return theString;
	}
	/*
	public String toString(){
		String theString = "Hourly Employee:\tID: "+this.employeeId+"\tName: "+this.firstName+" "+this.lastName+"\tHourly Rate: "+this.hourlyRate;"
		return theString;	}
	*/

	@Override
	public String payToString(String startDate, String endDate) {
		// Take incoming strings and make them useful Date objects
				DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyyMMdd-HH:mm");
				DateTime startedDate = DateTime.parse(startDate, formatter);
				DateTime endedDate = DateTime.parse(endDate, formatter);
				double paySum=0;
				for(TimeCard t : timeCards){
							
					if(t.getDayOfYear() >= startedDate.getDayOfYear() && t.getDayOfYear() <= endedDate.getDayOfYear() && t.getYear() >= startedDate.getYear() && t.getYear() <= endedDate.getYear()){
					paySum += t.calculateDailyPay(hourlyRate);
					
					}
				}
				//return paySum;
				//this.getPayMethod().pay(this.getFullNameFL(), paySum);
				return this.getPayMethod().payToString(this.getFullNameFL(), paySum);
		
	}

}
