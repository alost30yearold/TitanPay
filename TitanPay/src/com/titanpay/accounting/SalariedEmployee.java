package com.titanpay.accounting;

import java.util.ArrayList;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class SalariedEmployee extends Employee implements Payable{
	
	private double salary;
	private double commissionRate;
	ArrayList<Receipt> receipts = new ArrayList<Receipt>();
	
	public SalariedEmployee(int employeeId, String firstName,String lastName, double weeklyDues, double commissionRate, double salary, Address address){
		super(employeeId, firstName, lastName, weeklyDues, address);
		
		this.salary = salary;
		this.commissionRate = commissionRate;
	}
	public void makeSale(double amount){
		Receipt madeSale = new Receipt(amount);
		receipts.add(madeSale);
		System.out.println("added sales receipt: ");
		
	}
	/*
	@Override
	public double performPay(DateTime startDate, DateTime endDate) {
		double paySum = this.salary;
		for(Receipt r : receipts){
			
			if(r.getDateOfMonth() >= startDate.getDayOfMonth() && r.getDateOfMonth() <= endDate.getDayOfMonth()){
				paySum += r.calculateCom(commissionRate);
	
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
		double paySum = this.salary;
		for(Receipt r : receipts){
			
			if(r.getDateOfMonth() >= startedDate.getDayOfMonth() && r.getDateOfMonth() <= endedDate.getDayOfMonth()){
				paySum += r.calculateCom(commissionRate);
	
			}
		}
		//return paySum;
		this.getPayMethod().pay(this.getFullNameFL(), paySum);
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
