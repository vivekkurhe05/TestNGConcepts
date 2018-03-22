package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
		
	// PageFactory - Object Repository
	
	@FindBy(name = "username")
	WebElement username;
	
	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(xpath = "//input[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(xpath = "//button[contains(text(),'Sign Up')]")
	WebElement signUpBtn;
	
	@FindBy(className = "img-responsive")
	WebElement crmLogo;
	
	//How will you initialize PageFactory elements
	//Answer - with the help of initElements method of class PageFactory
	
	
	//Initializing the page objects
	public LoginPage() throws IOException {
		PageFactory.initElements(driver, this);
//		PageFactory.initElements(driver, LoginPage.class);
	}
	
	
	//Actions:
	public String validateLoginPageTitle(){
		
		return driver.getTitle();
		
	}
	
	public boolean validateCRMImage(){
		
		return crmLogo.isDisplayed();
		
	}
	
	
	public HomePage login(String un, String pwd) throws IOException{
		
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		
		return new HomePage();
		
	}
	

	
	
	
	

}
