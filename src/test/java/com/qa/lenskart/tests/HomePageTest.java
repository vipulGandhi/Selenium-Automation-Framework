package com.qa.lenskart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
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
	
	@DataProvider
	public Object[][] serchItems()
	{
		Object[][] searchObjects = new Object[3][1];
		
		searchObjects[0][0] = "Contact Lenses";
		searchObjects[1][0] = "Eyeglasses";
		searchObjects[2][0] = "Sunglasses";
		
		return searchObjects;		
	}
	
	@Test(priority = 3, dataProvider= "serchItems")
	public void searchTest(String mySearchItems)
	{
		searchPage = homePage.doSearch(mySearchItems);
		Assert.assertTrue(searchPage.getHeading(mySearchItems).trim().toLowerCase().equals(mySearchItems.trim().toLowerCase()));
	}
}
