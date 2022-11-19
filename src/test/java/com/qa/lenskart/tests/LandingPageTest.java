package com.qa.lenskart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LandingPageTest extends BaseTest
{
	@Test(priority = 1)
	public void titleTest()
	{
		Assert.assertTrue(landingPage.isTitlePresent());
	}
	
	@Test(priority = 2)
	public void urlTest()
	{
		Assert.assertTrue(landingPage.isUrlPresent());
	}
	
	@Test(priority = 3)
	public void logoTest()
	{
		Assert.assertTrue(landingPage.isLogoDisplayed());
	}
	
	@Test(priority = 4)
	public void signInTest()
	{
	 	homePage = landingPage.doSignIn(properties.getProperty("email"), properties.getProperty("password"));
	 	Assert.assertEquals(homePage.getUserName(), properties.getProperty("username"));
		
	}
}
