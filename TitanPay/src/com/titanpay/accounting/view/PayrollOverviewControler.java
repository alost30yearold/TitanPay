package com.titanpay.accounting.view;

import java.util.List;

import com.titanpay.accounting.MainApp;
import com.titanpay.accounting.employee.Employee;
import com.titanpay.accounting.employee.HourlyEmployee;
import com.titanpay.accounting.employee.SalariedEmployee;
import com.titanpay.payapp.CsvReader;
import com.titanpay.payapp.Receipt;
import com.titanpay.payapp.TimeCard;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PayrollOverviewControler {
	@FXML
    private TextField startDateField;
    @FXML
    private TextField endDateField;
    @FXML
    private ListView<String> payedS;
    
    private ObservableList<String> payedPeople = FXCollections.observableArrayList();
 
    private boolean payrollClicked = false;

    private MainApp mainApp;

    public PayrollOverviewControler() {
    }
    
    @FXML
    private void initialize() {
    	
    }
    /**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
 
    @FXML
    private void handleRunPayroll() {

    	for (HourlyEmployee employee : mainApp.getEmployeesHour()){
    		if (employee.payToString(startDateField.getText(), endDateField.getText()) != null)
    		payedPeople.add(employee.payToString(startDateField.getText(), endDateField.getText()));
    		
    	}
    	for (SalariedEmployee employee : mainApp.getEmployeesSal()){
    		if (employee.payToString(startDateField.getText(), endDateField.getText()) != null)
    		payedPeople.add(employee.payToString(startDateField.getText(), endDateField.getText()));
    	}

    	payedS.setItems(payedPeople);
    	//payed.setItems(mainApp.gethEmployeesData());
    		
    	payrollClicked = true;
    }
}
