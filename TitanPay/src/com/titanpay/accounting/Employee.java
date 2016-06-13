package com.titanpay.accounting;

//import java.util.ArrayList;


public abstract class Employee {
	
	
	private int employeeId;
	private String firstName;
	private String lastName;
	private double weeklyDues;
	private Address address;
	protected PaymentMethod payMethod;

	public Employee(int employeeId, String firstName,String lastName, double weeklyDues, Address address){//,PaymentMethod payMethod){

		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.weeklyDues = weeklyDues;
		this.address = address;
		//this.payMethod = PickUpPayment;
	}
	public abstract void pay(String start,String end);

	public String getFullNameLF(){
		String fullName = this.lastName+", "+this.firstName;
		return fullName;
	
	}
	public String getFullNameFL(){
		String fullName = this.firstName+" "+this.lastName;
		return fullName;
	
	}
	@Override
	public String toString(){
		String theString = "Employee:\tID: "+this.employeeId+"\tName: "+this.firstName+" "+this.lastName;
		return theString;	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	public PaymentMethod getPayMethod() {
		return payMethod;
	}
	public void setPayMethod(PaymentMethod payMethod) {
		this.payMethod = payMethod;
	}
 
}