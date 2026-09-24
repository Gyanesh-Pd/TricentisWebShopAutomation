package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public final class HomePage extends BrowserUtility {

	//Locators --------------->
	private static final By LOG_IN_LINK_LOCATOR = By.xpath("//a[contains(text(),'Log in')]");
	
	//Constructor ------------>
	public HomePage(WebDriver driver) {
		super(driver);		//To call the Parent Class constructor from Child Class Constructor
		gotoWebPage("https://demowebshop.tricentis.com/");
		maximizeWindow();
	}
	
	//Page functions with return----------->
	public LoginPage gotoLogInPage() {
		clickOn(LOG_IN_LINK_LOCATOR);
		LoginPage loginPage = new LoginPage(getDriver());
		return loginPage;
	}
	
}
