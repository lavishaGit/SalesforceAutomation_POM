package com.salesforce.utility;

import java.awt.dnd.DropTargetDragEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.tekarch.salesforce.base.BaseTest;

public class SalesforceListenerUtility extends BaseTest implements ITestListener {
	Logger ListenerLog = LogManager.getLogger();
	private static ExtentUtility report = ExtentUtility.getinstance();

//This Iltestlistener listen to the events before exceuting any test methods 

	// related to the @test level

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		ListenerLog.info(result.getMethod().getMethodName() + ".......test execution started........");
		report.startExtentCreateReport(result.getMethod().getMethodName() + ".......execution started........");
		// Test container for report is created........");

	}

//related to the @test level
	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		ListenerLog.info(result.getMethod().getMethodName() + ".......test execution sucess........");
		report.logTestwithPassed(result.getMethod().getMethodName() + ".......testexecution sucess........");
		// execution sucess........");

	}
	// related to the @test level

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		ListenerLog.error(result.getMethod().getMethodName() + ".......test execution completed with failure........");
		report.logTestwithFailed(
				result.getMethod().getMethodName() + ".......test execution completed with failure........");
		String filename = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
		String path = Constants.screenshotsFilepath + filename + ".png";
		takescreenshot(path);
		report.logTestfailwithScreenshot(path);
		report.logTestfailwithException(result.getThrowable());

	}
	// related to the @test level

	// before any <test> starts exceution this will get executed,one time excution

	@Override
	public void onStart(ITestContext context) {
		// context contains all the informa about the tests
		ListenerLog.info(".......<test> execution started........");
		report.startExtentReport();
	}

	// After any <test> starts exceution
	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ListenerLog.info(".......<test> execution completed........");
		report.endReport();

	}

}
