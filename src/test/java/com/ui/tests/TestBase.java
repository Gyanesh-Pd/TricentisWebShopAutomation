package com.ui.tests;

import static com.constants.Browser.EDGE;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;

import com.ui.pages.HomePage;
import com.utility.BrowserUtility;
import com.utility.LoggerUtility;

public class TestBase {

	protected HomePage homePage;
	Logger logger = LoggerUtility.getLogger(this.getClass());

	@BeforeMethod(description = "Loads HomePage before Test method execution")
	public void setup() {
		logger.info("Loading HomePage of Application");
		homePage = new HomePage(EDGE,true); // import static com.constants.Browser.* instead of Browser.CHROME
	}
	
	public BrowserUtility getInstance()
	{
		return homePage;
	}
}
