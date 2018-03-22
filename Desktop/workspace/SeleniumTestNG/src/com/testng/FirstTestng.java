package com.testng;

import org.testng.annotations.Test;

public class FirstTestng {
	
	@Test(priority=1)
	public void firstTestCase(){
		System.out.println("In First Test Case");
	}
	
	@Test(priority=2)
	public void secondTestCase(){
		System.out.println("In Second Test Case");
	}
	
	@Test(priority=3)
	public void thirdTestCase(){
		System.out.println("In Third Test Case");
	}
	
	@Test(priority=4)
	public void fourthTestCase(){
		System.out.println("In Fourth Test Case");
	}

}
