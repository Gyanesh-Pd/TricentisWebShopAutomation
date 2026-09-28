package com.ui.tests;

import static com.constants.Browser.*;
import static org.testng.Assert.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.ui.pages.HomePage;

public class LoginTest3 {

	HomePage homePage;
	
	@BeforeMethod(description = "Loads HomePage before Test method execution")
	public void setup() {
		homePage = new HomePage(CHROME); // import static com.constants.Browser.* instead of Browser.CHROME
	}

	@Test(description = "Verify valid user log In", groups = { "sanity", "e2e" })
	public void loginTest() {

		assertEquals(homePage.gotoLogInPage().doLoginWith("wakir22560@meonvr.com", "Tempmail2026").getUserNameText(),
				"wakir22560@meonvr.com");
	}
}
