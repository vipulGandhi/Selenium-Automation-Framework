package com.qa.lenskart.tests;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import com.qa.lenskart.factory.DriverFactory;
import com.qa.lenskart.pages.HomePage;
import com.qa.lenskart.pages.LandingPage;
import com.qa.lenskart.pages.ProductInfoPage;
import com.qa.lenskart.pages.SearchPage;


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
		// Or, delete the temp files by yourself :)
		try {
			FileUtils.deleteDirectory(new File("/Users/vipulgandhi/Desktop/AA"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// The temporary files are deleted automatically once driver.quit() is called
		driver.quit();
	}
}
