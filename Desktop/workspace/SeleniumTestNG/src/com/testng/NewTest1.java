package com.testng;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class NewTest1 {
	
	@BeforeClass
	public void login(){
		System.out.println("Login NewTest1 successfully");
	}
	
	@Test(priority=1)
	public void addVendor(){
		System.out.println("Vendor is added");
	}
	
	@Test(priority=2)
	public void addProduct(){
		System.out.println("Product is added");
	}
	
	@Test(priority=3)
	public void addCurrency(){
		System.out.println("Currency is added");
	}
	
	@AfterClass
	public void logout(){
		System.out.println("logout NewTest1 successfully");
	}
	
	

}
