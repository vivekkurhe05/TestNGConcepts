package com.crm.qa.testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {
	
	
	TestUtil testUtil;
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	WebDriver driver;

	public ContactsPageTest() throws IOException {
		super();
	}
	
	
	
	@BeforeMethod
	public void setUp() throws IOException{
		
		initialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		contactsPage = new ContactsPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchToFrame(); //This will switch to particular frame where contacts link is available
		contactsPage = homePage.clickOnContactsLink();
	}


	@Test(priority=1)
	public void verifyContactsPageLabel(){
		
		Assert.assertTrue(contactsPage.verifyContactsLabel(),"Contacts label is missing on the page");
		
	}
	
	@Test(priority=2)
	public void selectSingleContactsTest(){
		
		contactsPage.selectContactsByName("Aamy Aadams");
		
	}
	
	
	@Test(priority=3)
	public void selectMultipleContactsTest(){
		
		contactsPage.selectContactsByName("Aamy Aadams");
		contactsPage.selectContactsByName("abc abc");
		
	}

	
	@DataProvider
	public void getTestData(){
		
	}
	
	
	@Test(priority=4)
	public void validateCreateNewContact(){
		
		homePage.clickOnNewContactLink();
		contactsPage.createNewContact("Mr.", "Vivek", "Kurhe", "Bynry");
		
	}
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}


}
