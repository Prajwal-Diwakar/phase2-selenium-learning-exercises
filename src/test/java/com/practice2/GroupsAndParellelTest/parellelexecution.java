package com.practice2.GroupsAndParellelTest;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class parellelexecution {
	WebDriver driver;
	
	@Test (groups="amazon")
	
	public void search() {
	
	String siteUrl = "https://www.amazon.in/";
	String driverPath = "drivers/windows/chromedriver.exe";
	
	// step2: set system properties for selenium dirver
			System.setProperty("webdriver.chromedriver.driver", driverPath);

			// step3: instantiate selenium webdriver
			driver = new ChromeDriver();

			// step4: launch browser
			driver.get(siteUrl);
	
}
	
	@Test(groups="amazon", dependsOnMethods="search")
	
	public void enter() throws InterruptedException {
		
		WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
		searchBox.clear();
		searchBox.sendKeys("Dell Laptops");
		searchBox.submit();

		// add delay 
		Thread.sleep(2000);
		
		String expectedTitle = "Amazon.in : Dell Laptops";
		String actualTitle = driver.getTitle();
		
		assertEquals(actualTitle, expectedTitle);
	}
	
	@AfterClass
	public void closeup() {
		driver.close();
	}
		
}

