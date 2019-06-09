package com.syntax.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.syntax.utils.BaseClass;

public class AddEmployeePage extends BaseClass {
	
	/*TestCase: Add Employee Verification
Step 1: Login to the OrangeHRM
Step 2: Click on PIM
Step 3: Click on Add Employee
Step 4: Enter fName, lName, select Location
Step 5 Click Save
Step 6: Verify employee is added
	 */
	
	@FindBy(id="firstName")
    public WebElement firstName;
    
    @FindBy(id="middleName")
    public WebElement middleName;
    
    @FindBy(id="lastName")
    public WebElement lastName;
    
    @FindBy(id="employeeId")
    public WebElement employeeId;
    
    
    
    public AddEmployeePage() {
        PageFactory.initElements(driver,this);
    }
	
	

}
