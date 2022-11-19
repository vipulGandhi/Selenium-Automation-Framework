package com.qa.lenskart.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import com.qa.lenskart.factory.DriverFactory;
import com.qa.lenskart.pages.*;


public class BaseTest
{
	
	DriverFactory driverFactory;
	WebDriver driver;
	Properties properties;
	LandingPage landingPage;
	HomePage homePage;

	
	@BeforeTest
	public void setUp()
	{
		System.out.println("I'm called");
		driverFactory = new DriverFactory();
		properties = driverFactory.initProperties();
		driver = driverFactory.initWebDriver(properties);
		landingPage = new LandingPage(driver);
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
}
