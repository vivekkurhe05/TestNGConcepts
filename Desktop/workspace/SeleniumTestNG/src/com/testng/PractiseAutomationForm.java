package com.testng;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PractiseAutomationForm {
	
	Properties prop;
	File f;
	FileInputStream fis;
	WebDriver driver;
		
//	@BeforeClass
//	public void setUp() throws IOException{
//		
//		if(prop.getProperty("browser").equals("firefox")){
//			prop = new Properties();
//			f = new File(prop.getProperty("file"));
//			fis = new FileInputStream(f);
//			prop.load(fis);
//			
//			System.setProperty("webdriver.gecko.driver", "C:/Users/sai/workspace/geckodriver-v0.16.1-win32/geckodriver.exe");
//
//			driver = new FirefoxDriver();
//			driver.get(prop.getProperty("url"));
//			
//		}
//		else{
//			System.err.println("Browser is not chrome. Please check the practiceform.properties file");
//			driver.close();
//		}
//					
//	}
	
	
	@BeforeClass
	public void setUp() throws IOException{
		System.setProperty("webdriver.gecko.driver", "C:/Users/sai/workspace/geckodriver-v0.16.1-win32/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("http://toolsqa.com/automation-practice-form/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	}
	
	@Test(priority=1)
	public void enterData(){
		
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("window.scrollBy(0,500)");
		driver.findElement(By.name("firstname")).sendKeys("Vivek");
		driver.findElement(By.name("lastname")).sendKeys("Kurhe");
		
		
	}
	

}
