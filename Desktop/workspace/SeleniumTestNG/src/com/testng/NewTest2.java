package com.testng;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class NewTest2 {
	
	@BeforeClass
	public void login(){
		System.out.println("Login NewTest2 successfully");
	}
	
	@Test(priority=1)
	public void deleteVendor(){
		System.out.println("Vendor is deleted");
	}
	
	@Test(priority=2)
	public void deleteProduct(){
		System.out.println("Product is deleted");
	}
	
	@Test(priority=3)
	public void deleteCurrency(){
		System.out.println("Currency is deleted");
	}
	
	@AfterClass
	public void logout(){
		System.out.println("logout NewTest2 successfully");
	}


}
