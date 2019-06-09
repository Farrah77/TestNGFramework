package com.syntax.utils;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonMethods extends BaseClass {


/**
 * @author Syntax 
 * This method will select a specified value from a drop down by visible text
 * @parameter Select element, String text
 */
    public static void selectValueFromDD(WebElement element, String text) {
        
        Select select=new Select(element);
        List<WebElement> options=select.getOptions();
        boolean isSelected=false;
        for (WebElement option:options) {
            String optionText=option.getText();
            if (optionText.equals(text)) {
                select.selectByVisibleText(text); 
                System.out.println("Option with text "+text+" is selected");
                isSelected=true;
                break; //once we find the value we are looking for, we stop it; break;
            }
        }
        if(!isSelected) {
            System.out.println("Option with text "+text+" is NOT available");
        }
    }
    
    /**
     * @autor Syntax
     * This method will select a specified value from a drop down by its index
     * @parm Select element, int index
     */
    public static void selectValueFromDD(WebElement element, int index) { //method overloading
        
        Select select=new Select(element);
        List<WebElement> options=select.getOptions();
        
        if (options.size()>index) {
            select.selectByIndex(index);
        }else {
            System.out.println("Invalid index has been passed");
        }
        select.deselectByIndex(index);
        
    }
    
    public static void sendText(WebElement element, String value) {
        element.clear();
        element.sendKeys(value);
    }
/**
 * Method will accept alert
 * @throws NoAlertPresentException if alert is not present
 */
    public static void acceptAlert() {
        try {
           Alert alert=driver.switchTo().alert();
           alert.accept();
        }catch(NoAlertPresentException e) {
            System.out.println("Alert was not present");
        }
    }
/**
 * Method will dismiss alert
 * @throws NoAlertPresentException if alert is not present
 */ 
    public static void dismissAlert() {
        try {
            Alert alert=driver.switchTo().alert();
            alert.dismiss();
        }catch(NoAlertPresentException e) {
            System.out.println("Alert was not present");
        }
    }
    /**
     * Method will get text of an alert
     * @throws NoAlertPresentException if alert is not present
     * @return String text
     */ 
    public static String getAlertText() {
        
        try {
            Alert alert=driver.switchTo().alert();
            return alert.getText();
        }catch(NoAlertPresentException e) {
            System.out.println("Alert was not present");
            return null;
        }
    }
    /**
     * Method that will switch control to the specify frame
     * @throws NoSuchFrameException if frame is not present
     * @param frame id or frame name
     */ 
    public static void switchToFrame(String idOrName) {
        try {
            driver.switchTo().frame(idOrName);
        }catch(NoSuchFrameException e) {
            System.out.println("Frame is not present");
        }
    }
    /**
     * Method that will switch control to the specify frame
     * @param frame element
     */ 
    public static void switchToFrame(WebElement element) { //method overloading
        try {
            driver.switchTo().frame(element);
        }catch(NoSuchFrameException e) {
            System.out.println("Frame is not present");
        }
    }
    /**
     * Method that will switch control to the specify frame
     * @param frame index
     */
    public static void switchToFrame(int index) { //method overloading
        try {
            driver.switchTo().frame(index);
        }catch(NoSuchFrameException e) {
            System.out.println("Frame is not present");
        }
    }
        
        /**
    	 * Method that will wait for element to be visible
    	 * 
    	 * @param WebElement element, int time
    	 */
    	public static void waitForElementBeVisible(WebElement element, int time) {
    		WebDriverWait wait = new WebDriverWait(driver, time);
    		wait.until(ExpectedConditions.visibilityOf(element));
    	}

    	public static void waitForElementBeVisible(By locator, int time) {
    		WebDriverWait wait = new WebDriverWait(driver, time);
    		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    	}

    	public static void waitForElementBeClickable(WebElement element, int time) {
    		WebDriverWait wait = new WebDriverWait(driver, time);
    		wait.until(ExpectedConditions.elementToBeClickable(element));
    	}

    	public static void waitForElementBeClickable(By locator, int time) {
    		WebDriverWait wait = new WebDriverWait(driver, time);
    		wait.until(ExpectedConditions.elementToBeClickable(locator));
    	}
        
        public static void takeScreenshot(String folderName, String fileName) {
    		TakesScreenshot ts=(TakesScreenshot)driver;
            File scr=ts.getScreenshotAs(OutputType.FILE);
            
            try {
    		FileUtils.copyFile(scr, new File("screenshots/"+folderName+"/"+fileName+".png"));
    		} catch (IOException e) {
    			e.printStackTrace();
    			System.out.println("Unable to take screesnhot");
    		}
    	}
        
        /**
    	 * Method that will scroll down the page using Javascript
    	 * 
    	 * @param int pixels
    	 */
        public static void scrollDown(int pixels) {
    		JavascriptExecutor js=(JavascriptExecutor)driver;
    		js.executeScript("window.scrollBy(0,"+pixels+")");
    	}
        /**
    	 * Method that will scroll up the page using Javascript
    	 * 
    	 * @param int pixels
    	 */
    	public static void scrollUp(int pixels) {
    		JavascriptExecutor js=(JavascriptExecutor)driver;
    		js.executeScript("window.scrollBy(0,-"+pixels+")");
    	}
    	/**
    	 * Method that will click the button using Javascript
    	 * 
    	 * @param WebElement element
    	 */
    	public static void jsClick(WebElement element) {
    		
    		JavascriptExecutor js=(JavascriptExecutor)driver;
    		js.executeScript("arguments[0].click();", element);
    	}
    	
    	public static void click(WebElement element) {
    		element.click();
    	}
        
    }