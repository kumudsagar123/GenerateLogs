package com.tests;

import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class LoginTest {

	WebDriver driver;
	Logger logger=Logger.getLogger(LoginTest.class);
	@BeforeMethod
	public void setUp()
	{
	System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32 new\\chromedriver.exe");
	 driver=new ChromeDriver();
	logger.info("Launching chrome browser");
	    driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://classic.crmpro.com");
		logger.info("Entering application url");
		logger.warn("This is just a warning message");
		logger.debug("This is debug message");
	 
	}
	
	@Test(priority=1)
	public void verifyTitle(){
		logger.info("******************Free CRM TEST******************");
		String title=driver.getTitle();
		System.out.println(title);
		logger.info("Title is displayed");
		Assert.assertEquals(title, "CRMPRO - CRM software for customer relationship management, sales, and support.");
	}
	@Test(priority=2)
	public void verifyLogo(){
		boolean b=driver.findElement(By.xpath("//img[@class='img-responsive']")).isDisplayed();
		Assert.assertTrue(b);
		logger.info("Logo is displayed");
		
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
