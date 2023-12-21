package com.practice1.testannotations;

import org.testng.annotations.*;

public class testannotions {
	

	@Test
	public void Test1() {
		System.out.println("Test1 Executed");
	}
	@Test
	public void Test2() {
		System.out.println("Test2 Executed");
	
	}
	
	@AfterTest
	public void AfterTest() {
		System.out.println("AfterTest Executed");
	}
	
	
	@Test
	public void Test3() {
		System.out.println("Test3 Executed");
	}
	
	
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("Before Test is Executed");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("BeforeMethod Executed");
	}
	
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("AfterMethod Executed");
	}
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("BeforeClass Executed");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("AfterClass Executed");
	}


	
	
}
