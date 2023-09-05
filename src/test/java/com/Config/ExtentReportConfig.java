package com.Config;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;



public class ExtentReportConfig {
	
	public static ExtentReports extentReports;
	public static ExtentTest test;
	
	public static ExtentReports getExtentReports() {
		if (extentReports==null) {
		
			ExtentSparkReporter htmlReporter=new ExtentSparkReporter("extent-report.html");
			extentReports = new ExtentReports();
            extentReports.attachReporter(htmlReporter);
		}
            return extentReports;
 
	}
	
	public static ExtentTest createTest(String testName) {
		test=extentReports.createTest(testName);
		return test;
		
		
	}

}
