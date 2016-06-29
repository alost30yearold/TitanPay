package com.titanpay.accounting.employee;

//import java.util.ArrayList;


public abstract class Employee implements Payable {
	
	
	private int employeeId;
	private String firstName;
	private String lastName;
	private double weeklyDues;
	private Address address;
	private PaymentMethod payMethod;

	public Employee(){
		
	}
	
	public Employee(int employeeId, String firstName,String lastName, double weeklyDues, Address address,PaymentMethod payMethod){

		this.employeeId = employeeId;
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.weeklyDues = weeklyDues;
		this.address = address;
		this.payMethod = payMethod;
	}
	//public abstract void pay(String start,String end);

	public Employee(String firstName2, String lastName2) {
		this.setFirstName(firstName);
		this.setLastName(lastName);
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getFullNameLF(){
		String fullName = this.getLastName()+", "+this.getFirstName();
		return fullName;
	
	}
	public String getFullNameFL(){
		String fullName = this.getFirstName()+" "+this.getLastName();
		return fullName;
	
	}
	@Override
	public String toString(){
		String theString = "Employee:\tID: "+this.employeeId+"\tName: "+this.getFirstName()+" "+this.getLastName();
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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
 
}