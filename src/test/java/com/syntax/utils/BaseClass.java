package com.syntax.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass {

public static WebDriver driver;
    
    @BeforeMethod(alwaysRun = true)
    public static void setUp() {
        
        ConfigsReader.readProperties(Constants.CREDENTIALS_FILEPATH);
        String browser = ConfigsReader.getProperty("browser");
        
    	if (browser.equalsIgnoreCase("chrome")) {
            //for MAC
            System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");  
            //for WINDOWS
         // System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");  
            driver=new ChromeDriver();
        }else if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver");
            driver=new FirefoxDriver();
            //for Internet Explorer(won't work for mac
        } else if (browser.equalsIgnoreCase("ie")) {
            System.setProperty("webdriver.ie.driver", "src/test/resources/drivers/IEDriverServer");
            driver=new FirefoxDriver();
           
        } else {
            System.out.println("Browser given is wrong");
        }
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().fullscreen();
        driver.get(ConfigsReader.getProperty("url"));
    }
    @AfterMethod(alwaysRun = true)
    public void tearDown() {
    	driver.close();
    }
}
