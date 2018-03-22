package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {

	public ContactsPage() throws IOException {
		super();
		PageFactory.initElements(driver, ContactsPage.class);
	}
	
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement contactsLabel;
	
	@FindBy(id = "first_name")
	WebElement firstName;
	
	@FindBy(id = "surname")
	WebElement lastName;
	
	@FindBy(name = "client_lookup")
	WebElement company;
	
	
	@FindBy(xpath = "//input[@type='submit' and @value='Save']")
	WebElement saveBtn;
	
	
	public boolean verifyContactsLabel(){
		return contactsLabel.isDisplayed();
	}
	
	
	
	public void selectContactsByName(String name){
		
		driver.findElement(By.xpath("//a[contains(text(),'"+name+"')]"
				+ "/parent::td[@class='datalistrow']"
				+ "/preceding-sibling::td[@class='datalistrow']"
				+ "//input[@name='contact_id']")).click();
	}
	
	
	public void createNewContact(String title, String firstname, String lastname, String cmp){
		
		Select select = new Select(driver.findElement(By.xpath("//select[@name='title']")));
		select.selectByVisibleText(title);
		
		firstName.sendKeys(firstname);
		lastName.sendKeys(lastname);
		company.sendKeys(cmp);
		saveBtn.click();
			
	}
	

}
