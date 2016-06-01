package com.titanpay.accounting;

public class Employee {
	
	private int employeeId;
	private String firstName;
	private String lastName;
	private double hourlyRate;
	private double weeklyDues;

	public Employee(int employeeId, String firstName,String lastName, double hourlyRate, double weeklyDues){
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.hourlyRate = hourlyRate;
		this.weeklyDues = weeklyDues;
	}

	public String getFullName(){
		String fullName = this.lastName+", "+this.firstName;
		return fullName;
	
	}


}