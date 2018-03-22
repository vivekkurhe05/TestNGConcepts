package com.testng;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class UploadPhoto {
	
	static WebDriver driver;
	static JavascriptExecutor js;
	static WebElement element;
	static String photoUrl="C:\\Users\\sai\\Desktop\\my photo\\200vivek.jpg";
	
	@Test(timeOut=50000, invocationCount=5)
	public void launchBrowser(){
		
		System.out.println("Launching Firefox Browser...");
		System.setProperty("webdriver.gecko.driver", "C:/Users/sai/workspace/geckodriver-v0.16.1-win32/geckodriver.exe");
		driver=new FirefoxDriver();
		driver.get("http://toolsqa.com/automation-practice-form/");
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	 
	@Test
	public void uploadFile(){
		js=(JavascriptExecutor)driver;
		element=driver.findElement(By.id("photo"));
		js.executeScript("arguments[0].scrollIntoView(true)", element);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id='photo']")).sendKeys(photoUrl);

	}

}
