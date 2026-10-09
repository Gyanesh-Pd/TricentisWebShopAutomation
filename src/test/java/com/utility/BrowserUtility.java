package com.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.constants.Browser;

public abstract class BrowserUtility {

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	Logger logger = LoggerUtility.getLogger(this.getClass());

	public WebDriver getDriver() {
		return driver.get();
	}

	public BrowserUtility(WebDriver webDriver) {
		BrowserUtility.driver.set(webDriver);
	}

	public BrowserUtility(String browserName) {
		logger.info("Launching Browser {}", browserName);
		if (browserName.equalsIgnoreCase("chrome")) {
			driver.set(new ChromeDriver());
		} else if (browserName.equalsIgnoreCase("edge")) {
			driver.set(new EdgeDriver());
		} else {
			System.err.println("Invalid Browser... Select Chrome or Edge only");
		}
	}

	public BrowserUtility(Browser browserName) {
		logger.info("Launching Browser {}", browserName);
		if (browserName == Browser.CHROME) {
			driver.set(new ChromeDriver());
		} else if (browserName == Browser.EDGE) {
			driver.set(new EdgeDriver());
		} else if (browserName == Browser.FIREFOX) {
			driver.set(new FirefoxDriver());
		}
	}

	public BrowserUtility(Browser browserName, boolean isHeadless) {
		logger.info("Launching Browser {}", browserName);

		if (browserName == Browser.CHROME) {
			if (isHeadless) {
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless");
				options.addArguments("--window-size=1920,1080");
				driver.set(new ChromeDriver(options));
			} else {
				driver.set(new ChromeDriver());
			}
		} else if (browserName == Browser.EDGE) {
			if (isHeadless) {
				EdgeOptions options = new EdgeOptions();
				options.addArguments("--headless");
				options.addArguments("disable-gpu");
				options.addArguments("window-size=1920,1080");
				driver.set(new EdgeDriver(options));
			} else {
				driver.set(new EdgeDriver());
			}
		} else if (browserName == Browser.FIREFOX) {
			if (isHeadless) {
				FirefoxOptions options = new FirefoxOptions();
				options.addArguments("--headless");
				options.addArguments("--window-size=1920,1080");
				driver.set(new FirefoxDriver(options));
			} else {
				driver.set(new FirefoxDriver());
			}
		}
	}

	public void gotoWebPage(String url) {
		logger.info("Visiting url {}", url);
		driver.get().get(url);
	}

	public void maximizeWindow() {
		logger.info("Maximizing Window");
		driver.get().manage().window().maximize();
	}

	public void clickOn(By locator) {
		logger.info("Clicking on Locator {}", locator);
		WebElement element = driver.get().findElement(locator);
		element.click();
	}

	public void enterText(By locator, String inputText) {
		logger.info("Finding element with Locator {}", locator);
		WebElement element = driver.get().findElement(locator);

		logger.info("Entering Text in the element {}", inputText);
		element.sendKeys(inputText);
	}

	public String getVisibleText(By locator) {
		logger.info("Finding element with Locator {}", locator);
		WebElement element = driver.get().findElement(locator);

		logger.info("Text from found element {}", element.getText());
		return element.getText();
	}

	public String takeScreenShot(String testName) {
		TakesScreenshot screenshotDriver = (TakesScreenshot) driver.get();

		File screenshotData = screenshotDriver.getScreenshotAs(OutputType.FILE);

		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("HH-mm-ss");
		String timeStamp = dateFormat.format(date);

		String path = System.getProperty("user.dir") + "//screenshots//" + testName + "-" + timeStamp + ".png";
		File screenshotFile = new File(path);

		try {
			FileUtils.copyFile(screenshotData, screenshotFile);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return path;
	}
}
