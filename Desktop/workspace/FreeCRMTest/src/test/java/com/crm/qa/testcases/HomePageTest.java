package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TasksPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {
	
	public HomePageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}


	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	DealsPage dealsPage;
	TasksPage tasksPage;

	
	@BeforeMethod
	public void setUp() throws IOException{
		
		initialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));		
	}
	
	@Test(priority=1)
	public void homePageTitleTest(){
		
		String title=homePage.verifyHomePageTitle();
		Assert.assertEquals(title, "CRMPRO","Home page title not matched");
	}
	
	@Test(priority=2)
	public void verifyUserNameTest(){
		
		testUtil.switchToFrame();
		boolean username=homePage.verifyCorrectUserName();
		Assert.assertTrue(username);
	}
	
	
	@Test(priority=3)
	public void verifyContactsLinkTest() throws IOException{
		testUtil.switchToFrame();
		contactsPage=homePage.clickOnContactsLink();
	}
	
	@Test(priority=4)
	public void verifyDealsLinkTest() throws IOException{
		testUtil.switchToFrame();
		dealsPage=homePage.clickOnDealsLink();
	}
	
	
	@Test
	public void verifyTasksLinkTest() throws IOException{
		testUtil.switchToFrame();
		tasksPage = homePage.clickOnTasksLink();
		
	}
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
