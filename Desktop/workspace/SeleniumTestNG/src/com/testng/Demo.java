package com.testng;

import org.testng.annotations.Test;

public class Demo {
	
	@Test(priority=1)
	public void testOne(){
		System.out.println("Test one");
	}
	
	@Test(priority=2)
	public void testTwo(){
		System.out.println("Test two");
	}

	@Test(priority=3)
	public void testThree(){
		System.out.println("Test three");
	}

	@Test(priority=4)
	public void testFour(){
		System.out.println("Test four");
	}

	@Test(priority=5)
	public void testFive(){
		System.out.println("Test five");
	}

	@Test(priority=6)
	public void testSix(){
		System.out.println("Test six");
	}

	

}
