package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(xpath = "//td[contains(text(),'Naveen K')]")
	WebElement userNameLabel;
	
	@FindBy(xpath = "//a[contains(@title,'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath = "//a[contains(@title,'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath = "//a[contains(@title,'Tasks')]")
	WebElement tasksLink;
	
	@FindBy(xpath = "//a[text()='Contacts']/following-sibling::ul//li//a[text()='New Contact']")
	WebElement newContactLink;
	
	
	public HomePage() throws IOException {
		
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle(){
		
		return driver.getTitle();
		
	}
	
	public boolean verifyCorrectUserName(){
		
		return userNameLabel.isDisplayed();
	}
	
	
	public ContactsPage clickOnContactsLink() throws IOException{

		contactsLink.click();
		return new ContactsPage();
	}
	
	public DealsPage clickOnDealsLink() throws IOException{
		dealsLink.click();
		return new DealsPage();
		
	}
	
	public TasksPage clickOnTasksLink() throws IOException{
		tasksLink.click();
		return new TasksPage();
		
	}
	
	public void clickOnNewContactLink(){
		Actions action = new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		newContactLink.click();
		
	}
	

}
