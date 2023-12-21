package com.practice2.GroupsAndParellelTest;

import org.testng.annotations.Test;

public class Groups {
	
	@Test(groups = "Practice")
	public void r1() {
		System.out.println("Test 1 is executed ");
	}
	
	@Test(groups = "Practice")
	public void r2() throws InterruptedException {
		
		System.out.println("Test 2 is executed ");
	}
	
	@Test(groups = "Practice")
	public void r3() {
		System.out.println("Test 3 is executed");
	}

}
