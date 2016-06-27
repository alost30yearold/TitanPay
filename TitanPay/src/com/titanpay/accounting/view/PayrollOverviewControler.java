package com.titanpay.accounting.view;

import java.util.List;

import com.titanpay.accounting.employee.HourlyEmployee;
import com.titanpay.accounting.employee.SalariedEmployee;
import com.titanpay.payapp.CsvReader;
import com.titanpay.payapp.Receipt;
import com.titanpay.payapp.TimeCard;

import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PayrollOverviewControler {
	@FXML
    private TextField startDateField;
    @FXML
    private TextField endDateField;
   
    
    List<HourlyEmployee> employeesHour;
    List<SalariedEmployee> employeesSal;
   // List<TimeCard> employeesTimeCard;
   // List<Receipt> employeesReceipts;
    @FXML
    private TableView<HourlyEmployee> empHTable;
    
   // private Stage dialogStage;

    private boolean okClicked = false;

    
    @FXML
    private void initialize() {
    	employeesHour = CsvReader.parseHourlyEmployees("hourly_employees.csv");	
		//employeesTimeCard = CsvReader.parseTimeCards("timecards.csv");
		for (HourlyEmployee employee : employeesHour){
			List<TimeCard> hourETimeCard = CsvReader.parseTimeCards("timecards.csv",employee.getEmployeeId());
			employee.setTimeCardsArray(hourETimeCard);
		}
			
		employeesSal = CsvReader.parseSalariedEmployees("salaried_employees.csv");
		for (SalariedEmployee employee : employeesSal) {
			List<Receipt> salEReceipt = CsvReader.parseReceipts("receipts.csv",employee.getEmployeeId());
			employee.setReceiptsArray(salEReceipt);
		}
		
    }
    /**
     * Returns true if the user clicked OK, false otherwise.
     * 
     * @return
     */
    public boolean isOkClicked() {
        return okClicked;
    }
    @FXML
    private void handleRunPayroll() {
    	
    	//String sTime = startDateField.getText();
    	//System.out.println(employeesHour);
    	for (HourlyEmployee employee : employeesHour){
    		employee.pay(startDateField.getText(), endDateField.getText());
    	}
    	for (SalariedEmployee employee : employeesSal){
    		employee.pay(startDateField.getText(), endDateField.getText());
    	}
    	// okClicked = true;
         //dialogStage.close();
    	
    	
    	
    	
    	
    	
    }
       /* Person tempPerson = new Person();
        boolean okClicked = mainApp.showPersonEditDialog(tempPerson);
        if (okClicked) {
            mainApp.getPersonData().add(tempPerson);
        }*/
}
