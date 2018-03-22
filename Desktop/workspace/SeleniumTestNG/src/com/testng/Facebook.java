package com.testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class Facebook {
	
	static WebDriver driver;
	static String pageTitle;
	
	@BeforeClass
	public void configureSetUp(){
		
		System.setProperty("webdriver.gecko.driver", "C:/Users/sai/workspace/geckodriver-v0.16.1-win32/geckodriver.exe");
		driver=new FirefoxDriver();
		driver.get("http://www.facebook.com");
		driver.manage().deleteAllCookies();
	}
	
	@Test
	public void verifyPageTitle(){
		
		pageTitle=driver.getTitle();
		Assert.assertEquals(pageTitle, "Facebook - log in or sign up");
		
	}
	
	@AfterClass
	public void closeBrowser(){
		
		driver.quit();
	}
	
	
	

}
