package com.ui.tests;

import static com.constants.Browser.EDGE;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.ui.pages.HomePage;
import com.utility.BrowserUtility;
import com.utility.LambdaTestUtility;
import com.utility.LoggerUtility;

public class TestBase {
	protected HomePage homePage;
	Logger logger = LoggerUtility.getLogger(this.getClass());
	private boolean isLambdaTest = false;
	private boolean isHeadless = true;

	@BeforeMethod(description = "Loads HomePage before Test method execution")
	public void setup(ITestResult result) {
		WebDriver lambdaDriver;

		if (isLambdaTest) {
			lambdaDriver = LambdaTestUtility.initializeLambdaTestSession("chrome", result.getMethod().getMethodName());
			homePage = new HomePage(lambdaDriver);
		} else {
			logger.info("Loading HomePage of Application");
			// import static com.constants.Browser.* instead of Browser.CHROME
			homePage = new HomePage(EDGE, isHeadless);
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
