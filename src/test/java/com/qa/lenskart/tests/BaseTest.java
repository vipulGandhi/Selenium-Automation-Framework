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
	SearchPage searchPage;
	
	@BeforeTest
	public void setUp()
	{
		System.out.println("1");
		driverFactory = new DriverFactory();
		System.out.println("1");
		properties = driverFactory.initProperties();
		System.out.println("1");
		driver = driverFactory.initWebDriver(properties);
		System.out.println("1");
		landingPage = new LandingPage(driver);
		System.out.println("1");
	}
	
	@AfterTest
	public void tearDown()
	{
	//	driver.quit();
	}
}
