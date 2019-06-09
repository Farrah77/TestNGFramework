package com.syntax.testcases;

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

	@Test
	public void loginToOrangeHRM() {
		LoginPageWithoutPageFactory login=new LoginPageWithoutPageFactory();
		
		CommonMethods.sendText(login.username, "Admin");
		CommonMethods.sendText(login.password, "06I@PjFbgM");
		CommonMethods.click(login.btnLogin);
		
	}
	
	@Test
	public void doLogin() {
		LoginPage login=new LoginPage();
		CommonMethods.sendText(login.userName, ConfigsReader.getProperty("username"));
		CommonMethods.sendText(login.password, ConfigsReader.getProperty("password"));
		CommonMethods.click(login.loginBtn);
		
		HomePage home = new HomePage();
		boolean isDisplayed= home.dashboardText.isDisplayed();
		Assert.assertTrue(isDisplayed);
	}
	
	@Test
	public void negativeLogin() {
		LoginPage login = new LoginPage();
		
		login.login("Admin", "password");
		
		String error = login.errorText.getText();
		
		Assert.assertEquals(error, "Invalid Credentials");
		
		
//		CommonMethods.sendText(login.userName, "Admin"); other option 
//		CommonMethods.sendText(login.password, "password");
//		CommonMethods.click(login.loginBtn);
	}
}