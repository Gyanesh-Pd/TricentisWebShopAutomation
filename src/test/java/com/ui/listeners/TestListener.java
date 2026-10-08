package com.ui.listeners;

import java.util.Arrays;

import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.ui.tests.TestBase;
import com.utility.BrowserUtility;
import com.utility.ExtentReporterUtility;
import com.utility.LoggerUtility;

public class TestListener implements ITestListener {

	Logger logger = LoggerUtility.getLogger(this.getClass());

	@Override
	public void onTestStart(ITestResult result) {
		logger.info(result.getMethod().getMethodName());
		logger.info(result.getMethod().getDescription());
		logger.info("Groups: {}", Arrays.toString(result.getMethod().getGroups()));
		ExtentReporterUtility.createExtentTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		logger.info(result.getMethod().getMethodName(), " PASSED");
		ExtentReporterUtility.getExtentTest().log(Status.PASS, result.getMethod().getMethodName() + " PASSED");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		logger.error(result.getMethod().getMethodName(), " FAILED");
		logger.error(result.getThrowable().getMessage());
		ExtentReporterUtility.getExtentTest().log(Status.FAIL, result.getMethod().getMethodName() + " FAILED");
		ExtentReporterUtility.getExtentTest().log(Status.FAIL, result.getThrowable().getMessage());
		
		Object testMethodInstanceObject = result.getInstance();
		BrowserUtility browserUtility = ((TestBase)testMethodInstanceObject).getInstance();
		logger.error("Capturing ScreenShot of Failed Test");
		String screenShotPath = browserUtility.takeScreenShot(result.getMethod().getMethodName());
		
		logger.error("Attaching screenshot to HTML Report");
		ExtentReporterUtility.getExtentTest().addScreenCaptureFromPath(screenShotPath);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		logger.warn(result.getMethod().getMethodName(), " SKIPPED");
		ExtentReporterUtility.getExtentTest().log(Status.SKIP, result.getMethod().getMethodName() + " SKIPPED");
	}

	@Override
	public void onStart(ITestContext context) {
		logger.info("Test Suite Started");
		ExtentReporterUtility.setupSparkReporter("report.html");
	}

	@Override
	public void onFinish(ITestContext context) {
		logger.info("Test Suite Completed");
		ExtentReporterUtility.flushReport();
	}
}
