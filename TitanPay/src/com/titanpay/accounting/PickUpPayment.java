 package com.titanpay.accounting;

public class PickUpPayment extends PaymentMethod {

	public PickUpPayment(String eName, double paymentAmount) {
		super(eName, paymentAmount);
	}

	public void pay(String eName, double paymentAmount) {
		System.out.println("A check for "+paymentAmount+" is waiting for "+eName+" at the PostMaster.");

	}

}
