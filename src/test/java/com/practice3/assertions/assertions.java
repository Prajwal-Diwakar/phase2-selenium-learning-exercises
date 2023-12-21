package com.practice3.assertions;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.testng.Assert;
	import org.testng.annotations.Test;
	import org.testng.asserts.SoftAssert;

	public class assertions {
		
		SoftAssert soft = new SoftAssert();
		WebDriver driver;
		@Test
		public void Launch() {
			String siteUrl = "https://www.facebook.com";
			String driverPath = "drivers/windows/chromedriver.exe";
			
			// step2: set system properties for selenium dirver
					System.setProperty("webdriver.chromedriver.driver", driverPath);

					// step3: instantiate selenium webdriver
					driver = new ChromeDriver();

					// step4: launch browser
					driver.get(siteUrl);
		}
			

		@Test(dependsOnMethods = { "Launch" })
		
		public void Facebook() {
		
			soft.assertEquals("FB Title", driver.getTitle());	
			try {
				Thread.sleep(2000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		@Test(dependsOnMethods = { "Facebook" })
		public void Login() {
			driver.findElement(By.id("email")).sendKeys("abcd@gmail.com");
			driver.findElement(By.id("pass")).sendKeys("xxxxx");
			driver.findElement(By.id("loginbutton")).click();
			soft.assertAll();
			
			try {
				Thread.sleep(3000);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}


