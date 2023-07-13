// One method should have one hard assertions and multiple soft assertions

package com.qa.lenskart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class LandingPageTest extends BaseTest
{
	// For every @Test, the browser server gets started and we are launching and quitting browser for every @Test methods
	// Selenium provides us an option to control starting and killing of browser server
		// We can use TestNG annotated methods to start server once and kill it after suite is completed.
		// 
	@Description("Landing page title test")
	@Severity(SeverityLevel.MINOR)
	@Test(priority = 1)
	// Deliberately faling this test
	// Selenium wait exception will be thrown here
		// No Assert error will be thrown
	public void titleTest()
	{
		Assert.assertTrue(landingPage.isTitlePresent());
	}
	
	@Description("Url test")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 2)
	public void urlTest()
	{
		Assert.assertTrue(landingPage.isUrlPresent());
	}
	
	@Description("Logo display test")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority = 3)
	public void logoTest()
	{
		Assert.assertTrue(landingPage.isLogoDisplayed());
	}
	
	@Description("Sign In test with valid credentials")
	@Severity(SeverityLevel.BLOCKER)
	@Test(priority = 4)
	public void signInTest()
	{
	 	homePage = landingPage.doSignIn(properties.getProperty("email"), properties.getProperty("password"));
	 	Assert.assertEquals(homePage.getUserName(), properties.getProperty("username"),
	 			"User is unable to sign in with valid credentials");
	}
}
