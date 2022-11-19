package com.qa.lenskart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.lenskart.utils.Constants;

public class HomePageTest extends BaseTest
{
	
	@BeforeClass
	public void test()
	{
		homePage = landingPage.doSignIn(properties.getProperty("email"), properties.getProperty("password"));
	}
	
	@Test(priority = 1)
	public void userNameTest()
	{
		Assert.assertEquals(homePage.getUserName(), properties.getProperty("username"));
	}
	
	@Test(priority = 2)
	public void loginPanelItemsTest()
	{
		Assert.assertEquals(homePage.getLoginPanelItems(), Constants.loginPanelItems());
	}
	
	
	
	@Test(priority = 3)
	public void searchTest()
	{
		homePage.doSearch("Contact Lenses");
	}
}
