package com.titanpay.accounting;

import java.util.ArrayList;

import org.joda.time.DateTime;

public interface Payable {
	public void pay(String startDate,String endDate);
	//public double performPay(DateTime startDate, DateTime endDate);

}
