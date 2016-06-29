package com.titanpay.accounting.employee;

import java.util.ArrayList;

import org.joda.time.DateTime;

public interface Payable {
	public void pay(String startDate,String endDate);

	String payToString(String startDate, String endDate);

	//public void payToString(String startDate, String endDate);

	
	//public double performPay(DateTime startDate, DateTime endDate);

}
