package com.qa.lenskart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.lenskart.utils.Constants;

public class SearchPageTest extends BaseTest
{
	
	@BeforeClass
	public void test()
	{
		homePage = landingPage.doSignIn(properties.getProperty("email"), properties.getProperty("password"));
		searchPage = homePage.doSearch("Contact Lens");
	}
	
	@Test(priority = 1)
	public void userNameTest()
	{
		Assert.assertEquals(homePage.getUserName(), properties.getProperty("username"));
	}
}
