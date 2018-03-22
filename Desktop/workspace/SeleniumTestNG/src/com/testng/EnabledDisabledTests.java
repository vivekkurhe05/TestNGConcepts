package com.testng;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EnabledDisabledTests {
	
	
	@BeforeMethod
	public void testOne(){
		System.out.println("I am in first test");
	}

	@Test(priority=2)
	public void testTwo(){
		System.out.println("I am in second test");
	}
	
	@AfterMethod
	public void testThree(){
		System.out.println("I am in third test");
	}
	
	
}
