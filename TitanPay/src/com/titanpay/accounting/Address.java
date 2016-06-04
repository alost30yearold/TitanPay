package com.titanpay.accounting;

public class Address {
	private String streetAddress;
	private String city;
	private String state;
	private int zip;

	public Address(String streetAddress, String city, String state, int zip){
		this.streetAddress = streetAddress;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}
	
	public String getAddress() {
		String address = streetAddress + city + state + zip;
		return address;
	}
	@Override
	public String toString(){
		String theString = "Address :\tSalary: "+this.streetAddress+"\tCity: "+this.city+"\tState: "+this.state+"\tZip: "+zip;
		return theString;
	}
}