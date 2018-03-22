package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.qa.util.TestUtil;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	
	public TestBase() throws IOException{
		
		prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\sai\\Desktop\\workspace"
				+ "\\FreeCRMTest\\src\\main\\java"
				+ "\\com\\crm\\qa\\config\\config.properties");
		prop.load(fis);	
	}
	
	public static void initialization() throws IOException{
				
		String browsername = prop.getProperty("browser");
		if(browsername.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\sai"
					+ "\\Downloads\\Compressed\\chromedriver_win32\\chromedriver.exe");
			
			driver = new ChromeDriver();
		}
		else if(browsername.equals("firefox")){
			
			System.setProperty("webdriver.gecko.driver", "C:/Users/sai/workspace"
					+ "/geckodriver-v0.16.1-win32/geckodriver.exe");
			
//			System.setProperty("webdriver.gecko.driver", "C:\\Users\\sai\\Desktop\\workspace"
//					+ "\\geckodriver-v0.16.1-win32\\geckodriver.exe");
			
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		
		
		
	}
}
