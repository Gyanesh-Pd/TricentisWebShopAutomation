package com.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class BrowserUtility {

	private WebDriver driver;

	
	public WebDriver getDriver() {
		return driver;
	}

	public BrowserUtility(WebDriver driver) {
		this.driver = driver;
	}

	public void gotoWebPage(String url) {
		driver.get(url);
	}

	public void maximizeWindow() {
		driver.manage().window().maximize();
	}

	public void clickOn(By locator) {
		WebElement element = driver.findElement(locator);
		element.click();
	}

	public void enterText(By locator, String inputText) {
		WebElement element = driver.findElement(locator);
		element.sendKeys(inputText);
	}

	public String getVisibleText(By locator)
	{
		WebElement element = driver.findElement(locator);
		return element.getText();
	}
}
