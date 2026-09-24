package com.ui.tests;

import com.ui.pages.HomePage;

public class LoginTest3 {

	public static void main(String[] args) {

		HomePage homePage = new HomePage("chrome");
		String loggedUserName = homePage.gotoLogInPage().doLoginWith("wakir22560@meonvr.com", "Tempmail2026").getUserNameText();
		System.out.println("Logged UserName : " + loggedUserName);
	}
}
