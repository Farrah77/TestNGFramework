package com.syntax.testcases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.interactions.SendKeysAction;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.syntax.pages.HomePage;
import com.syntax.pages.LoginPage;
import com.syntax.pages.LoginPageWithoutPageFactory;
import com.syntax.utils.BaseClass;
import com.syntax.utils.CommonMethods;
import com.syntax.utils.ConfigsReader;

public class LoginPageTest extends BaseClass{

	@Test(groups = "smoke")
	public void loginToOrangeHRM() {
		LoginPageWithoutPageFactory login=new LoginPageWithoutPageFactory();
		
		CommonMethods.sendText(login.username, "Admin");
		CommonMethods.sendText(login.password, "06I@PjFbgM");
		CommonMethods.click(login.btnLogin);
		
	}
	
	@Test(enabled=false)
	public void doLogin() {
		LoginPage login=new LoginPage();
		CommonMethods.sendText(login.userName, ConfigsReader.getProperty("username"));
		CommonMethods.sendText(login.password, ConfigsReader.getProperty("password"));
		CommonMethods.click(login.loginBtn);
		
		HomePage home = new HomePage();
		boolean isDisplayed= home.dashboardText.isDisplayed();
		AssertJUnit.assertTrue(isDisplayed);
	}
	
	@Test(groups="regression")
	public void negativeLogin() {
		LoginPage login = new LoginPage();
		
		login.login("Admin", "password");
		
		String error = login.errorText.getText();
		
		AssertJUnit.assertEquals(error, "Invalid Credentials");

	}
}