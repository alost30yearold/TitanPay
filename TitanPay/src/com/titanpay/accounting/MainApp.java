package com.titanpay.accounting;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.util.List;

import com.titanpay.accounting.employee.Address;
import com.titanpay.accounting.employee.BankAccount;
import com.titanpay.accounting.employee.DirectDepositPayment;
import com.titanpay.accounting.employee.Employee;
import com.titanpay.accounting.employee.HourlyEmployee;
import com.titanpay.accounting.employee.SalariedEmployee;
import com.titanpay.accounting.view.PayrollOverviewControler;
import com.titanpay.payapp.CsvReader;
import com.titanpay.payapp.Receipt;
import com.titanpay.payapp.TimeCard;


import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;



public class MainApp extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;
    private ObservableList<HourlyEmployee> hEmployeesData = FXCollections.observableArrayList();
    private ObservableList<SalariedEmployee> sEmployeesData = FXCollections.observableArrayList();
    //private ObservableList<String> payedPeople = FXCollections.observableArrayList();
    private List<HourlyEmployee> employeesHour;
    private List<SalariedEmployee> employeesSal;

    public MainApp(){
    	employeesHour = CsvReader.parseHourlyEmployees("hourly_employees.csv");	
		//employeesTimeCard = CsvReader.parseTimeCards("timecards.csv");
    	
		for (HourlyEmployee employee : employeesHour){
			List<TimeCard> hourETimeCard = CsvReader.parseTimeCards("timecards.csv",employee.getEmployeeId());
			employee.setTimeCardsArray(hourETimeCard);
		}
		//System.out.println(employeesHour);
			
		employeesSal = CsvReader.parseSalariedEmployees("salaried_employees.csv");
		
		for (SalariedEmployee employee : employeesSal) {
			List<Receipt> salEReceipt = CsvReader.parseReceipts("receipts.csv",employee.getEmployeeId());
			employee.setReceiptsArray(salEReceipt);
		}

		/*List<HourlyEmployee> employees = CsvReader.parseHourlyEmployees("hourly_employees.csv");
        // Add some sample data
    	for (HourlyEmployee employee : employees) {
			System.out.println(employee.getFullNameLF());
			hEmployeesData.add(employee);
    	}*/
    	/*List<SalariedEmployee> employeesS = CsvReader.parseSalariedEmployees("salaried_employees.csv");
        // Add some sample data
    	for (SalariedEmployee employee : employeesS) {
			System.out.println(employee.getFullNameLF());
			sEmployeesData.add(employee);
    	}*/
    	//List<String> newList = new ArrayList<String>(listOne);
    	//newList.addAll(listTwo);
		
    	/*List<HourlyEmployee> employeestest = CsvReader.parseHourlyEmployees("hourly_employees.csv");
        // Add some sample data
    	for (HourlyEmployee employee : employeestest) {
			System.out.println(employee);
			employeesData.add(new HourlyEmployee(employee.getFirstName(), employee.getLastName()));
    	}*/
    	
    }
    
    
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("TitanPay App");

        initRootLayout();

        showPayrollOverview();
    }

    /**
     * Initializes the root layout.
     */
    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Shows the person overview inside the root layout.
     */
    public void showPayedEmployees(){
    	
    	
    	
    	
    	
    }
    
    
    public void showPayrollOverview() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/PayrollOverview.fxml"));
            AnchorPane payrollOverview = (AnchorPane) loader.load();

            // Set person overview into the center of root layout.
            rootLayout.setCenter(payrollOverview);
            
            // Give the controller access to the main app.
            PayrollOverviewControler controller = loader.getController();
            controller.setMainApp(this);
            
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public List<HourlyEmployee> getEmployeesHour() {
		return employeesHour;
	}


	public void setEmployeesHour(List<HourlyEmployee> employeesHour) {
		this.employeesHour = employeesHour;
	}


	public List<SalariedEmployee> getEmployeesSal() {
		return employeesSal;
	}


	public void setEmployeesSal(List<SalariedEmployee> employeesSal) {
		this.employeesSal = employeesSal;
	}


    /**
     * Returns the main stage.
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public ObservableList<HourlyEmployee> gethEmployeesData() {
		return hEmployeesData;
	}


	public void sethEmployeesData(ObservableList<HourlyEmployee> hEmployeesData) {
		this.hEmployeesData = hEmployeesData;
	}


	public ObservableList<SalariedEmployee> getsEmployeesData() {
		return sEmployeesData;
	}


	public void setsEmployeesData(ObservableList<SalariedEmployee> sEmployeesData) {
		this.sEmployeesData = sEmployeesData;
	}


	public static void main(String[] args) {
        launch(args);
    }
}