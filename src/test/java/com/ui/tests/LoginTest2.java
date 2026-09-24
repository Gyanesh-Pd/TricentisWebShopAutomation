package com.ui.tests;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.ui.pages.HomePage;
import com.ui.pages.LoginPage;

public class LoginTest2 {

	public static void main(String[] args) {
		
		WebDriver wd = new ChromeDriver(); // Browser Session Created

		HomePage homePage = new HomePage(wd);
		LoginPage loginPage = homePage.gotoLogInPage();
		loginPage.doLoginWith("wakir22560@meonvr.com","Tempmail2026");
		
	}
}
