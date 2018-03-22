package com.logfile;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogDemoFile {

	
	WebDriver driver;
	Logger log = Logger.getLogger("LogDemoFile");
	
	@BeforeMethod
	public void launchBrowser(){
		
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\sai\\workspace\\geckodriver-v0.16.1-win32\\geckodriver.exe");
		driver = new FirefoxDriver();
		log.info("Launching chrome browser");
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.get("https://www.freecrm.com/index.html");
		log.info("entering application url");
		log.warning("Hey this is just a warning message");
	}
	
	
	@Test(priority=1)
	public void verifyTitle(){
		
		log.info("Login page title is "+driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "#1 Free CRM for Any Business: Online Customer Relationship Software");
		
	}
	
	
	@Test
	public void verifyLogo(){
		
		
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

	
}
