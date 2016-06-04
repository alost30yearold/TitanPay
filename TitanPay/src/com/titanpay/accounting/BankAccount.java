package com.titanpay.accounting;

public class BankAccount {
		
	private String bankName;
	private int routingNumber;
	private String accountId;
	
	public BankAccount(String bankName, String accountId, int routingNumber){
		this.bankName = bankName;	
		this.accountId = accountId;
		this.routingNumber = routingNumber;
	}
	public String deposit(double amt){
		
		String depositMessage = "Depositing $" + amt +" in " + this.bankName +" Acount Number: "+ this.accountId+" using Routing Number: " +this.routingNumber;
		return depositMessage;
		
	}
	@Override
	public String toString(){
		String theString = "Bank Account :\tID: "+this.accountId+"\tRouting Number: "+this.routingNumber+"\tBank Name: "+this.bankName;
		return theString;
	}
}
