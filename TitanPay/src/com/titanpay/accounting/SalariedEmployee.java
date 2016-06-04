package com.titanpay.accounting;

public class SalariedEmployee extends Employee{
	
	private double salary;
	private double commissionRate;
	
	public SalariedEmployee(int employeeId, String firstName,String lastName, double weeklyDues, double commissionRate, double salary){
		super(employeeId, firstName, lastName, weeklyDues);
		
		this.salary = salary;
		this.commissionRate = commissionRate;
	}	
	@Override
	public String toString(){
		String theString = "Salaried Employee :\tSalary: "+this.salary+"\tCommission Rate: "+this.commissionRate;
		return theString;
	}
	/*public String toString(){
		String theString = "Salaried Employee:\tID: "+this.employeeId+"\tName: "+this.firstName+" "+this.lastName+"\tSalary: "+this.salary+"\tCommission Rate: "+this.commissionRate;"
		return theString;	}
	*/
}
