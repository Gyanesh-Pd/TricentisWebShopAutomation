package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public final class LoginPage extends BrowserUtility {

	static final By EMAIL_INPUT_BOX_LOCATOR = By.id("Email");
	static final By PASSWORD_INPUT_BOX_LOCATOR = By.id("Password");
	static final By LOGIN_BUTTON_LOCATOR = By.xpath("//input[@value='Log in']");
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public WelcomePage doLoginWith(String email, String password) {
		enterText(EMAIL_INPUT_BOX_LOCATOR, email);
		enterText(PASSWORD_INPUT_BOX_LOCATOR, password);
		clickOn(LOGIN_BUTTON_LOCATOR);
		WelcomePage welcomePage = new WelcomePage(getDriver());
		return welcomePage;
	}

}
