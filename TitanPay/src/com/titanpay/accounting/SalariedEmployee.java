package com.titanpay.accounting;

public class SalariedEmployee {
	private int employeeId;
	private String firstName;
	private String lastName;
	private double salary;
	private double commissionRate;
	private double weeklyDues;
	
	public SalariedEmployee(int employeeId, String firstName,String lastName, double hourlyRate, double weeklyDues, double commissionRate, double salary){
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
		this.commissionRate = commissionRate;
		this.weeklyDues = weeklyDues;
	}	
	public String getFullName(){
		String fullName = this.lastName+", "+this.firstName;
		return fullName;
	
	}
	
}
