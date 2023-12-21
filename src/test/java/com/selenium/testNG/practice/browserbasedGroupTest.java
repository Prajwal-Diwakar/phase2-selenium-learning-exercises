package com.selenium.testNG.practice;


	
	
	

	import static org.testng.Assert.assertEquals;
	import static org.testng.Assert.assertNotEquals;

	import java.time.Duration;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.testng.annotations.Test;

	public class browserbasedGroupTest {

		// step1: formulate a test domain url & driver path
		String amazonUrl = "https://www.amazon.in/";
		String facebookUrl = "https://www.facebook.com/";

		
		String driverPath = "drivers/windows/chromedriver.exe";

		WebDriver driver;
		
		WebDriverWait driverWait;

		@Test(groups = "amazon")
		public void launchChrome() {
			
			// step2: set system properties for selenium dirver
			System.setProperty("webdriver.chrome.driver", driverPath);

			// step3: instantiate selenium webdriver
			driver = new ChromeDriver();

			// step4: launch browser
			driver.get(amazonUrl);
		}
		
		@Test(groups = "amazon", description = "Test Amazon Home Page Title Match", dependsOnMethods="launchChrome", priority=1)
		public void testHomePageTitle() {
			String expectedTitle  = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
			String actualTitle  = driver.getTitle();
			assertEquals(actualTitle, expectedTitle);
		}
		
		@Test(groups = "amazon", description = "Test Amazon Home Page Title Invalid Match", dependsOnMethods="launchChrome", priority=3)
		public void testAmazonHomePageTitle2() {
			String expectedTitle  = "OOnline SShopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
			String actualTitle  = driver.getTitle();
			assertNotEquals(actualTitle, expectedTitle);
		}
		
		@Test(groups = "amazon", description = "Test Amazon Home Page Source Url", dependsOnMethods="launchChrome", priority=2)
		public void testHomePageSourceUrl() {
			assertEquals(driver.getCurrentUrl(), amazonUrl);
		}
		
		@Test (groups = "amazon", description = "Search Iphone 15 pro max", dependsOnMethods="launchChrome", priority=4)
		public void testSearch1() throws InterruptedException {
			WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
			searchBox.sendKeys("Redmi Phones");
			searchBox.submit();

			// add delay 
			Thread.sleep(2000);
			
			String expectedTitle = "Amazon.in : Iphone 15 pro max";
			String actualTitle = driver.getTitle();
			
			assertEquals(actualTitle, expectedTitle);
		}
		
		@Test(dependsOnGroups="amazon")
		public void closeChrome() {
			driver.close();
		}
		
		
		@Test(groups = "Facebook")
		public void launchFireFoxTest() {
			
			// step2: set system properties for selenium dirver
			System.setProperty("webdriver.chromedriver", driverPath);

			// step3: instantiate selenium webdriver
			driver = new ChromeDriver();
			driverWait = new WebDriverWait(driver, Duration.ofSeconds(50));
			// step4: launch browser
			driver.get(facebookUrl);
		}
		
		@Test(groups = "Facebook", dependsOnMethods="launchFireFoxTest", priority=1)
		public void testFaceBookHomePage() {
			String expected = "Facebook – log in or sign up";
			assertEquals(driver.getTitle(), expected);
		}
		
		@Test(groups = "Facebook", dependsOnMethods="launchFireFoxTest", priority=2)
		public void testFailureLogin() {
			driver.findElement(By.id("email")).sendKeys("abc@gmail.com");
			driver.findElement(By.id("pass")).sendKeys("abc@123");
			driver.findElement(By.name("login")).submit();
			
			// evaluate a failure login test
			WebElement errorMsg = driverWait.until(ExpectedConditions.visibilityOfElementLocated(
					By.cssSelector("#loginform > div:nth-child(12) > div._9ay7")));
			
			String errorText = "The password that you've entered is incorrect. Forgotten password?";
			assertEquals(errorText, errorMsg.getText());
		}
		
		@Test(dependsOnGroups="Facebook")
		public void closeFireFox() {
			driver.close();
		}
	

}
