package com.titanpay.accounting.employee;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import com.titanpay.payapp.Receipt;

public class SalariedEmployee extends Employee implements Payable{
	
	private double salary;
	private double commissionRate;
	ArrayList<Receipt> receipts = new ArrayList<Receipt>();
	
	public SalariedEmployee(int employeeId, String firstName,String lastName, double weeklyDues, double commissionRate, double salary, Address address,PaymentMethod payMethod){
		super(employeeId, firstName, lastName, weeklyDues, address, payMethod);
		receipts = new ArrayList<Receipt>();
		this.salary = salary;
		this.commissionRate = commissionRate;
	}
	public void makeSale(double amount){
		Receipt madeSale = new Receipt(amount);
		receipts.add(madeSale);
		System.out.println("added sales receipt: ");
		
	}
	public void setReceiptsArray(List<Receipt> receipt){
		receipts = (ArrayList<Receipt>) receipt;
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
		this.getPayMethod().pay(this.getFullNameFL(),paySum);
	}
	
	@Override
	public String toString(){
		String theString = "Salaried Employee : "+this.getFullNameFL()+"\tSalary: "+this.salary+"\tCommission Rate: "+this.commissionRate;
		return theString;
	}
	/*public String toString(){
		String theString = "Salaried Employee:\tID: "+this.employeeId+"\tName: "+this.firstName+" "+this.lastName+"\tSalary: "+this.salary+"\tCommission Rate: "+this.commissionRate;"
		return theString;	}
	*/
	@Override
	public String payToString(String startDate, String endDate) {
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
				return this.getPayMethod().payToString(this.getFullNameFL(),paySum);
		
	}
	
	
}
