package com.qa.lenskart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ProductInfoTest extends BaseTest
{
	@BeforeClass
	public void test()
	{
		homePage = landingPage.doSignIn(properties.getProperty("email"), properties.getProperty("password"));
	}
	
	@Test(priority = 1)
	public void productBrandNameTest()
	{
		searchPage = homePage.doSearch("Contact lens");
		productInfoPage = searchPage.selectProduct("Aqualens");
		Assert.assertTrue(productInfoPage.getProductBrandName().contains("Aqualens"));
	}
	
	@Test(priority = 2)
	public void productimageCount()
	{
		searchPage = homePage.doSearch("Contact lens");
		productInfoPage = searchPage.selectProduct("Aqualens");
		//Assert.assertTrue(productInfoPage.productImagesCount() > 0);
	}
}
