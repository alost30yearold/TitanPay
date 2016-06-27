package com.titanpay.accounting.employee;

import java.text.DecimalFormat;

public class DirectDepositPayment extends PaymentMethod {
	private BankAccount bankAccount;
	
	public DirectDepositPayment(String eName, double paymentAmount, BankAccount bankAccount) {
		super(eName, paymentAmount);
		this.bankAccount = bankAccount;
		
	}
	
	public void pay(String eName, double paymentAmount) {
		
		System.out.println(bankAccount.deposit(paymentAmount)+" for "+eName);

	}
	

}


