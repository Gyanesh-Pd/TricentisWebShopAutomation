package com.ui.tests;

import static com.constants.Browser.CHROME;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ui.pages.HomePage;
import com.ui.pojo.User;

public class LoginTest {

	HomePage homePage;
	
	@BeforeMethod(description = "Loads HomePage before Test method execution")
	public void setup() {
		homePage = new HomePage(CHROME); // import static com.constants.Browser.* instead of Browser.CHROME
	}

	@Test(description = "Verify valid User log In", groups = { "sanity", "e2e" }, 
			dataProviderClass=com.ui.dataproviders.LoginDataProvider.class, dataProvider = "LoginTestDataProvider")
	public void loginTest(User user) {

		assertEquals(homePage.gotoLogInPage().doLoginWith(user.getEmailAddress(),user.getPassword()).getUserNameText(),
				"wakir22560@meonvr.com");
	}	
}
