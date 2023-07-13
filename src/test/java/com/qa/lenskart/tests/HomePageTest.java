package com.qa.lenskart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.lenskart.utils.Constants;
import com.qa.lenskart.utils.ExcelUtil;

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
	
	@Test(priority = 2, enabled = false)
	public void loginPanelItemsTest()
	{
		Assert.assertEquals(homePage.getLoginPanelItems(), Constants.loginPanelItems());
	}
	
	//@DataProvider
//	public Object[][] serchItems()
//	{
//		Object[][] searchObjects = new Object[3][1];
//		
//		searchObjects[0][0] = "Contact Lens";
//		searchObjects[1][0] = "Eyeglasses";
//		searchObjects[2][0] = "Sunglasses";
//		
//		return searchObjects;		
//	}
	
	@DataProvider
	public Object[][] serchItems()
	{
		return ExcelUtil.getTestData(Constants.SHEET_NAME_SEARCH_ITEMS);
	}
	
	@Test(priority = 3, dataProvider= "serchItems")
	public void searchTest(String mySearchItems)
	{
		searchPage = homePage.doSearch(mySearchItems);
		Assert.assertTrue(searchPage.getHeading(mySearchItems).trim().toLowerCase().equals(mySearchItems.trim().toLowerCase()));
		Assert.assertTrue(searchPage.getTotalProductsAvailableCount() > 0);
	}
	
	@DataProvider
	public Object[][] productSelectionData()
	{
		Object[][] searchObjects = new Object[2][3];
		
		searchObjects[0][0] = "Contact Lens";
		searchObjects[0][1] = "Aqualens";
		searchObjects[0][2] = "Aqualens";
		
		searchObjects[1][0] = "Eyeglasses";
		searchObjects[1][1] = "Vincent Chase";
		searchObjects[1][2] = "Vincent Chase";

		return searchObjects;		
	}
	
	@Test(priority = 4, dataProvider= "productSelectionData", enabled = false)
	public void selectProductTest(String productParentSearch, String productBrandName, String productSearch)
	{
		searchPage = homePage.doSearch(productParentSearch);
		productInfoPage = searchPage.selectProduct(productSearch);
		Assert.assertTrue(productInfoPage.getProductBrandName().contains(productBrandName));
	}
}
