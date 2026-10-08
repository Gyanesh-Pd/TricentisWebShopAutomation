package com.ui.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pojo.User;

@Listeners(com.ui.listeners.TestListener.class)
public class LoginTest extends TestBase{

	@Test(description = "Verify valid User log In with JSON file", groups = { "sanity",
			"e2e" }, dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, dataProvider = "LoginTestDataProvider", retryAnalyzer = com.ui.listeners.MyRetryAnalyzer.class)
	public void loginJSONTest(User user) {
		assertEquals(homePage.gotoLogInPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserNameText(),
				"wakir22560@meonvr.com");
	}

	@Test(enabled = true, description = "Verify valid User log In with CSV file", groups = { "sanity",
			"e2e" }, dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, dataProvider = "LoginTestCSVDataProvider")
	public void loginCSVTest(User user) {
		assertEquals(homePage.gotoLogInPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserNameText(),
				"wakir22560@meonvr.com");
	}

	@Test(enabled = true, description = "Verify valid User log In with Excel file", groups = { "sanity",
			"e2e" }, dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, dataProvider = "LoginTestExcelDataProvider")
	public void loginExcelTest(User user) {
		assertEquals(homePage.gotoLogInPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserNameText(),
				"wakir22560@meonvr.com");
	}
}
