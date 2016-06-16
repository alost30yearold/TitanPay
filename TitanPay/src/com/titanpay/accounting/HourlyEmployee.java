package com.titanpay.accounting;

import java.util.ArrayList;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class HourlyEmployee extends Employee implements Payable {
	
	private double hourlyRate;
	ArrayList<TimeCard> timeCards = new ArrayList<TimeCard>();

	public HourlyEmployee(int employeeId, String firstName, String lastName, double weeklyDues, double hourlyRate, Address address,PaymentMethod payMethod) {
		super(employeeId, firstName, lastName, weeklyDues, address, payMethod);
		
		this.hourlyRate = hourlyRate;

	}
	public void clockIn(){
		TimeCard clockedIn = new TimeCard(DateTime.now());
		timeCards.ensureCapacity(31);
		timeCards.add(clockedIn);
		System.out.println("Clocked in at "+clockedIn);
	}
	public void clockIn(TimeCard time){
		TimeCard clockedIn = time;
		timeCards.ensureCapacity(31);
		timeCards.add(clockedIn);
		System.out.println("Clocked in at "+clockedIn);
	}
	public void clockOut(){
		DateTime currentDay = new DateTime();
		for (TimeCard t : timeCards){
			
			if(t.getDateOfMonth() == currentDay.getDayOfMonth() ){
	
				TimeCard clockedOut = t;
				clockedOut.setEndTime(DateTime.now());
				System.out.println("Clocked out at "+clockedOut);

			}
		}	
	}
	//May not work yet   v
	public void clockOut(TimeCard time){
		DateTime currentDay = time.getEndTime();
		for (TimeCard t : timeCards){
			
			if(t.getDateOfMonth() == currentDay.getDayOfMonth() ){
	
				TimeCard clockedOut = t;
				clockedOut.setEndTime(time.getEndTime());
				System.out.println("Clocked out at "+clockedOut);

			}
		}	
	}
	public void addTimeCard(TimeCard addd){
		timeCards.add(addd);

	}
	/*
	 * @Override
	public double performPay(DateTime startDate,DateTime endDate) {
		double paySum=0;
		for(TimeCard t : timeCards){
			
			if(t.getDateOfMonth() >= startDate.getDayOfMonth() && t.getDateOfMonth() <= endDate.getDayOfMonth()){
				paySum += t.calculateDailyPay(hourlyRate);
	
			}
		}
		return paySum;
	}
	*/
	@Override
	public void pay(String startDate, String endDate) {
		// Take incoming strings and make them useful Date objects
		DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyyMMdd-HH:mm");
		DateTime startedDate = DateTime.parse(startDate, formatter);
		DateTime endedDate = DateTime.parse(endDate, formatter);
		double paySum=0;
		for(TimeCard t : timeCards){
					
			if(t.getDateOfMonth() >= startedDate.getDayOfMonth() && t.getDateOfMonth() <= endedDate.getDayOfMonth()){
			paySum += t.calculateDailyPay(hourlyRate);
			
			}
		}
		//return paySum;
		//this.getPayMethod().pay(this.getFullNameFL(), paySum);
		payMethod.pay(this.getFullNameFL(), paySum);
	}
	@Override
	public String toString(){
		String theString = "Hourly Employee :\tHourly Rate: "+this.hourlyRate;
		return theString;
	}
	/*
	public String toString(){
		String theString = "Hourly Employee:\tID: "+this.employeeId+"\tName: "+this.firstName+" "+this.lastName+"\tHourly Rate: "+this.hourlyRate;"
		return theString;	}
	*/

	
	
	
	

}
