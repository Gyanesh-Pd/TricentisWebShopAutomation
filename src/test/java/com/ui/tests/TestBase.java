package com.ui.tests;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.constants.Browser;
import com.ui.pages.HomePage;
import com.utility.BrowserUtility;
import com.utility.LambdaTestUtility;
import com.utility.LoggerUtility;

public class TestBase {
	protected HomePage homePage;
	Logger logger = LoggerUtility.getLogger(this.getClass());
	private boolean isLambdaTest;

	@Parameters({ "browserName", "isLambdaTest", "isHeadless" })
	@BeforeMethod(description = "Loads HomePage before Test method execution")
	
	public void setup(
			@Optional("edge") String browserName,
			@Optional("false") boolean isLambdaTest,
			@Optional("true") boolean isHeadless,
			ITestResult result) {
		WebDriver lambdaDriver;
		this.isLambdaTest = isLambdaTest;

		if (isLambdaTest) {
			lambdaDriver = LambdaTestUtility.initializeLambdaTestSession(browserName,
					result.getMethod().getMethodName());
			homePage = new HomePage(lambdaDriver);
		} else {
			logger.info("Loading HomePage of Application");
			homePage = new HomePage(Browser.valueOf(browserName.toUpperCase()), isHeadless);
		}
	}

	public BrowserUtility getInstance() {
		return homePage;
	}

	@AfterMethod(description = "Tear Down Browser")
	public void tearDown() {
		if (isLambdaTest) {
			LambdaTestUtility.quitSession();
		} else {
			homePage.getDriver().quit();
		}
	}

}
