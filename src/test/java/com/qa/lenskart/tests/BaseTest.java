package com.qa.lenskart.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import com.qa.lenskart.factory.DriverFactory;
import com.qa.lenskart.pages.*;


public class BaseTest
{
	
	DriverFactory driverFactory;
	WebDriver driver;
	
	SoftAssert softAssert;
	
	Properties properties;
	LandingPage landingPage;
	HomePage homePage;
	SearchPage searchPage;
	ProductInfoPage productInfoPage;
	
	@BeforeMethod
	@BeforeTest
	public void setUp()
	{
		driverFactory = new DriverFactory();
		properties = driverFactory.initProperties();
		driver = driverFactory.initWebDriver(properties);
		softAssert = new SoftAssert();
		landingPage = new LandingPage(driver);
	}
	
	@AfterMethod
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
}
