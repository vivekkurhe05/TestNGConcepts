package com.testng;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Sample {
	
	WebDriver driver;
	Properties prop;
	FileInputStream fis;

	@BeforeClass
	public void setUp() throws IOException{
		
		System.out.println("Reading config file...");
		prop = new Properties();
		fis = new FileInputStream("C:\\Users\\sai\\Desktop\\workspace\\SeleniumTestNG\\config.properties");
		prop.load(fis);
		
	}
	
	@Test(priority=2, description="This test launches Chrome browser")
	public void launchBrowser(){
		
		System.out.println("Browser launching...");
		System.setProperty("webdriver.chrome.driver", "C:/Users/sai/Downloads/selenium setup/chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("http://www.facebook.com");
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		
	}
	
	@Test(priority=3, description="This test method enters data in Registration form", dependsOnMethods={"launchBrowser"})
	public void enterData(){
		
		System.out.println("Data feeding...");
		driver.findElement(By.id(prop.getProperty("firstname_id"))).sendKeys("Rajkumar");
		driver.findElement(By.id(prop.getProperty("surname_id"))).sendKeys("Hirani");
		driver.findElement(By.id(prop.getProperty("mobileno_id"))).sendKeys("7890098782");
		driver.findElement(By.id(prop.getProperty("newPassword_id"))).sendKeys("rajkumar123");
		
		
		Select daySelect = new Select(driver.findElement(By.id(prop.getProperty("day_id"))));
		daySelect.selectByVisibleText("5");
		
		Select monthSelect = new Select(driver.findElement(By.id(prop.getProperty("month_id"))));
		monthSelect.selectByVisibleText("Nov");
		
		Select yearSelect = new Select(driver.findElement(By.id(prop.getProperty("year_id"))));
		yearSelect.selectByVisibleText("2015");
		
		
	}

	@AfterClass
	public void closeBrowser() throws InterruptedException{
		
		Thread.sleep(2000);
		driver.quit();
		System.out.println("Browser closed...");
	}
	

}
