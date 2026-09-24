package com.ui.tests;

import static com.constants.Browser.*;
import com.ui.pages.HomePage;

public class LoginTest3 {

	public static void main(String[] args) {

		HomePage homePage = new HomePage(CHROME);  //import static com.constants.Browser.* instead of Browser.CHROME
		String loggedUserName = homePage.gotoLogInPage().doLoginWith("wakir22560@meonvr.com", "Tempmail2026").getUserNameText();
		System.out.println("Logged UserName : " + loggedUserName);
	}
}
