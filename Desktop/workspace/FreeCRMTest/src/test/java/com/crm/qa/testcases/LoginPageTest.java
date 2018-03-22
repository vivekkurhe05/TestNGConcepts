package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	
	public LoginPageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}


	LoginPage login;
	HomePage homePage;

	
	@BeforeMethod
	public void setUp() throws IOException{
		
		initialization();
		login=new LoginPage();
			
	}
	
	
	@Test(priority=1)
	public void loginPageTitleTest(){
		
		String title=login.validateLoginPageTitle();
		Assert.assertEquals(title, "#1 Free CRM for Any Business: Online Customer Relationship Software");
		
	}
	
	@Test(priority=2)
	public void crmLogoImageTest(){
		
		boolean isLogo = login.validateCRMImage();
		Assert.assertTrue(isLogo);
		
	}
	
	@Test(priority=3)
	public void loginTest() throws IOException{
		homePage = login.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
