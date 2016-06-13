package com.titanpay.accounting;

import java.util.ArrayList;

import org.joda.time.DateTime;

public interface Payable {

	//public Address getAddress();
	//public String getFullNameFL();
	//public double performPay(DateTime startDate, DateTime endDate);
	public void pay(String startDate,String endDate);

	//public String getFullNameFL();
	
	//public ArrayList<Payable> what = new ArrayList<Payable>();
}
