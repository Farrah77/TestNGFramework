package com.syntax.testcases;

import org.testng.annotations.Test;

import com.syntax.pages.AddEmployeePage;
import com.syntax.pages.HomePage;
import com.syntax.pages.LoginPage;
import com.syntax.utils.BaseClass;
import com.syntax.utils.CommonMethods;
import com.syntax.utils.ConfigsReader;

public class AddEmployeePageTest extends BaseClass {

	@Test
	public void addEmployee() {
		LoginPage login = new LoginPage();
		HomePage home = new HomePage();
		AddEmployeePage addEmp = new AddEmployeePage();
		
		login.login(ConfigsReader.getProperty("username"), ConfigsReader.getProperty("password"));
		
		
		CommonMethods.click(home.pim);
		CommonMethods.click(home.addBtn);
		
		CommonMethods.sendText(addEmp.firstName, "John");
		CommonMethods.sendText(addEmp.lastName, "Doe");
		
		
		
	}
}
