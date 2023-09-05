package com.Hooks;

import com.Config.ExtentReportConfig;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ExtentReportHooks {
	
		public static ExtentTest test;
		public static ExtentReports extentReports;
		
		@Before(order = 1)
	    public void setUp(Scenario scenario) {
	        extentReports = ExtentReportConfig.getExtentReports();
	        test = extentReports.createTest(scenario.getName()); // Create a test with the scenario name
	    }
	    
	    @After(order = 1)
	    public void tearDown(Scenario scenario) {
	        if (scenario.isFailed()) {
	            test.log(Status.FAIL, "Test Case Failed"); // Log test as failed if scenario fails
	        } else {
	            test.log(Status.PASS, "Test Case Passed"); // Log test as passed if scenario passes
	        }
	    }
	    
	    @After(order = 0)
	    public void flushReport() {
	    	extentReports.flush(); // Generate the Extent Report after all scenarios
	    }

	}


