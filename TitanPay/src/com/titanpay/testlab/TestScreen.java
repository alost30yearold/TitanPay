package com.titanpay.testlab;

import com.titanpay.accounting.BankAccount;
import com.titanpay.accounting.Employee;
import com.titanpay.accounting.TimeCard;

public class TestScreen {

	//private Time startTime;
	public static void main(String[] args) {

		Employee bob = new Employee(0, "Robert","Paulson", 0, 0); 
		System.out.println(bob.getFullName());
		BankAccount bobAccount = new BankAccount("Bank of Tulips", "695583", "817265GEK");
		System.out.println(bobAccount.deposit(1003.66));
		
		TimeCard bobPay = new TimeCard();
		System.out.println(bobPay.calculateDailyPay(10.00));
		
		
		

	}

}
