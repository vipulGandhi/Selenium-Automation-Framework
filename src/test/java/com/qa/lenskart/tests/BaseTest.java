package com.qa.lenskart.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
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
	
	@BeforeTest
	public void setUp()
	{
		driverFactory = new DriverFactory();
		properties = driverFactory.initProperties();
		driver = driverFactory.initWebDriver(properties);
		softAssert = new SoftAssert();
		landingPage = new LandingPage(driver);
	}
	
	@AfterTest
	public void tearDown()
	{
		// Or, delete the temp files by yopurself :)
		try {
			FileUtils.deleteDirectory(new File("/Users/vipulgandhi/Desktop/AA"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// The temporary files are deleted automatically once driver.quit() is called
		driver.quit();
	}
}
