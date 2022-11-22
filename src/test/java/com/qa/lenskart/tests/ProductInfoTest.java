package com.qa.lenskart.tests;

import java.util.Map;

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
		searchPage = homePage.doSearch("Eyeglasses");
		productInfoPage = searchPage.selectProduct("Vincent Chase");
		Assert.assertTrue(productInfoPage.productImagesCount() > 0);
	}
	
	@Test(priority = 3)
	public void getProductTechnicalInfo()
	{
		searchPage = homePage.doSearch("Contact lens");
		productInfoPage = searchPage.selectProduct("Aqualens");
		Map<String, String> productTechnicalInfoMap = productInfoPage.getProductTechnicalInfo();
		productTechnicalInfoMap.forEach((k,v) -> System.out.println(k + " " + v));
		
	}
}
