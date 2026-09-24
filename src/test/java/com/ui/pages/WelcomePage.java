package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public final class WelcomePage extends BrowserUtility{

	private static final By USER_NAME_TEXT_LOCATOR = By.xpath("//div[@class='header-links']//a[@class='account']");
	
	public WelcomePage(WebDriver driver) {
		super(driver);
	}

	public String getUserNameText()
	{
		return getVisibleText(USER_NAME_TEXT_LOCATOR);
	}
}
