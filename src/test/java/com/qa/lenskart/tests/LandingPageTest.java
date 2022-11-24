// One method should have one hard assertions and multiple soft assertions

package com.qa.lenskart.tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LandingPageTest extends BaseTest
{
	@Test(priority = 1)
	public void titleTest()
	{
		AssertJUnit.assertTrue(landingPage.isTitlePresent());
	}
	
	@Test(priority = 2)
	public void urlTest()
	{
		AssertJUnit.assertTrue(landingPage.isUrlPresent());
	}
	
	@Test(priority = 3)
	public void logoTest()
	{
		AssertJUnit.assertTrue(landingPage.isLogoDisplayed());
	}
	
	@Test(priority = 4)
	public void signInTest()
	{
	 	homePage = landingPage.doSignIn(properties.getProperty("email"), properties.getProperty("password"));
	 	AssertJUnit.assertEquals(homePage.getUserName(), properties.getProperty("username"));
	}
}
