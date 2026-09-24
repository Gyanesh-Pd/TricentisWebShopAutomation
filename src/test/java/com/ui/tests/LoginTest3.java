package com.ui.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.ui.pages.HomePage;

public class LoginTest3 {

	public static void main(String[] args) {

		WebDriver wd = new ChromeDriver(); // Browser Session Created

		HomePage homePage = new HomePage(wd);
		String loggedUserName = homePage.gotoLogInPage().doLoginWith("wakir22560@meonvr.com", "Tempmail2026").getUserNameText();
		System.out.println("Logged UserName : " + loggedUserName);
	}
}
