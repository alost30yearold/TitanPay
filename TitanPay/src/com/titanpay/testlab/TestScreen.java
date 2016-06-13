package com.titanpay.testlab;

import java.util.Scanner;

import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.joda.time.Interval;
import org.joda.time.ReadableDuration;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

import com.titanpay.accounting.Address;
import com.titanpay.accounting.BankAccount;
import com.titanpay.accounting.Employee;
import com.titanpay.accounting.HourlyEmployee;
import com.titanpay.accounting.MailPayment;
import com.titanpay.accounting.Receipt;
import com.titanpay.accounting.SalariedEmployee;
import com.titanpay.accounting.TimeCard;
import com.titanpay.accounting.PaymentMethod;
import com.titanpay.accounting.PickUpPayment;

public class TestScreen {

	//private Time startTime;
	public static void main(String[] args) {

		//Employee bob = new Employee(0, "Robert","Paulson", 0);
		Address bobHourAdd = new Address("6807 gullshit way", "Tampa", "FL", 33655);
		//SalariedEmployee bobSal = new SalariedEmployee(6255, "Robert", "Paulson", 20, .05, 20000.0, null);
		HourlyEmployee bobHour = new HourlyEmployee(6626, "Robert","Jones", 20, 10.50, bobHourAdd);
		
		//System.out.println(bob);
		//System.out.println(bobSal);
		//System.out.println(bobHour);
		TimeCard bobPay1 = new TimeCard("20160601-09:00", "20160601-16:00");
		TimeCard bobPay2 = new TimeCard("20160602-09:00", "20160602-16:00");
		TimeCard bobPay3 = new TimeCard("20160607-09:00", "20160607-16:00");
		TimeCard bobPay4 = new TimeCard();
		bobHour.addTimeCard(bobPay1);
		bobHour.addTimeCard(bobPay2);
		bobHour.addTimeCard(bobPay3);
		bobHour.addTimeCard(bobPay4);
		
		
		//bobHour.pay("20160601-09:00", "20160630-09:00");
		
		
		//bobHour.clockIn(bobPay1);
		//bobHour.timeCards.size();
		//bobHour.clockIn(bobPay2);
		//bobHour.clockIn(bobPay3);
		//bobHour.clockIn(bobPay4);
		
		//MailPayment fuckhjh = new MailPayment(bobHour.getFullNameFL(), bobHour.pay("20160601-09:00", "20160630-09:00"), bobHour.getAddress());
		//fuckhjh.pay();
		
		
		String startestTime = "20160601-09:00";
		String endestTime = "20160630-09:00";
		
		DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyyMMdd-HH:mm");
		DateTime starterTime = DateTime.parse(startestTime, formatter);
		DateTime enderTime = DateTime.parse(endestTime, formatter);
		
		
		
		
		
		
		DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyyMMdd-HH:mm");
		 String strInputDateTime = "20160516-15:23";
		    // string is populated with a date time string in some fashion
		    DateTime dt = fmt.parseDateTime(strInputDateTime);
		    String strOutputDateTime = fmt.print(dt);
		   // System.out.println(strOutputDateTime);
		
		
		
		
		
		
		
		 //   System.out.println(bobHour.pay(starterTime, enderTime));
		
		
		
		
		
		
		Scanner reader = new Scanner(System.in);  // Reading from System.in
		System.out.println("Enter a number: ");
		int n = reader.nextInt(); // Scans the next token of the input as an int.
		//bobHour.clockOut();

		
		//System.out.println(bobHour.getFullName());
		BankAccount bobAccount = new BankAccount("Bank of Tulips", "695583", 817265);
		//System.out.println(bobAccount.deposit(1003.66));
		
		TimeCard bobPay = new TimeCard("20160601-09:00", "20160601-16:00");
		//System.out.println(bobPay.calculateDailyPay(10.00));
	
		Receipt bobReceipt = new Receipt("20160601-08:00", 500);

		
		int year = 2016;
		int month = 6;
		int day = 1;
		int hour = 8;
		int min = 1;
		
		int year2 = 2016;
		int month2 = 6;
		int day2 = 1;
		int hour2 = 16;
		int min2 = 1;
		
		DateTime test = new DateTime(year,month,day,hour, min);
		DateTime test2 = new DateTime(year2,month2,day2,hour2, min2);
		
		//sum = test2 - test;
		
	//	int pay = hour2 - hour;
	//	TimeCard wtf = new TimeCard();
		//System.out.println(test);
		//System.out.println(test2);
		//System.out.println(pay);
		
		    
		    
		    
		    
		    DateTime start = new DateTime(2016, 6, 1, 0, 0);
		    DateTime end = new DateTime(2016, 6, 1, 0, 1);
		    Interval interval = new Interval(start, end);
		    
		  //  Duration.millis(arg0)
		    
		  //  Duration duration = interval.toDuration();
		    
		   // Duration time = Duration.standardHours(8);
		    
		   // Duration time2 = Duration.standardHours(8);
		    
		    //TimeCard bobPay = new TimeCard("20160601-09:00", "20160601-19:00");

		   // double calculatedPay = bobPay.calculateDailyPay(10);

		   // System.out.println(bobPay);
		    
		    
		    //System.out.println(bobAccount);
		    DateTime fuck = new DateTime();
		    fuck.getDayOfMonth();
		    //System.out.println(fuck.getDayOfMonth());
		    
		    
		    
		    TimeCard tester= new TimeCard();
		    
		  //System.out.println(tester.getStartTime());

		    
		 //   if (time.isLongerThan(time2)){
		  //  	System.out.println("time is longer than time 2");
		    	
		 //   }
		    
		    
		//    Duration fytf = time;
		 //   String fubar = duration.toString();
		 //   System.out.println(fubar);
		    /*
		    private int startYear = 2016;
		    private int startMonth = 6;
		    private int startDay = 1;
		    private int startHour = 9;
		    private int startMin = 1;

		    private int endYear = 2016;
		    private int endMonth = 6;
		    private int endDay = 1;
		    private int endHour = 17;
		    private int endMin = 1;

		    DateTime startTime = new DateTime(startYear,startMonth,startDay,startHour,startMin);
		    DateTime endTime = new DateTime(endYear,endMonth,endDay,endHour,endMin);
		    */  
		    
		    
	}

}
