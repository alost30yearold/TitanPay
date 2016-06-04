package com.titanpay.accounting;

public class HourlyEmployee extends Employee {
	
	private double hourlyRate;

	public HourlyEmployee(int employeeId, String firstName, String lastName, double weeklyDues, double hourlyRate) {
		super(employeeId, firstName, lastName, weeklyDues);
		
		this.hourlyRate = hourlyRate;

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
