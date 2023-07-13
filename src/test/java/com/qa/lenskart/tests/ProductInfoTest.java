// Hard assertions vs soft assertions
// Every @Test should have only one assertion

	// Hard Assertions
		// Throws Exception immediately if the assert statement fails and move to the next testcase
			// if there is any code in the current test case after assert statement it will not execute that statement
			// All the methods in the Assert class are static

	// Soft Assert
		// Do not throw an exception when an assertion fails and continue with the next step after the assert statement.
		// This is used when the test requires multiple assertions to be executed
		// Create a SoftAssert class object to access it's methods
		// softAssert.assertAll(); method is necessary to write after all SoftAssert methods
			// assertAll() method output the details of all the failed soft asertions

package com.qa.lenskart.tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.lenskart.utils.Errors;

public class ProductInfoTest extends BaseTest
{
	@BeforeClass
	public void test()
	{
		homePage = landingPage.doSignIn(properties.getProperty("email"), properties.getProperty("password"));
	}
	
	@Test(priority = 1, enabled = false)
	public void productBrandNameTest()
	{
		searchPage = homePage.doSearch("Contact lens");
		productInfoPage = searchPage.selectProduct("Aqualens");
		Assert.assertTrue(productInfoPage.getProductBrandName().contains("Aqualens"));
	}
	
	@Test(priority = 2)
	// Deliberately making this test fail
	// The Assert error message will be displayed only when Assert error is thrown
		// Not when Selenium exception is thrown (timeout exception etc.)
	public void productimageCount()
	{
		searchPage = homePage.doSearch("Eyeglasses");
		productInfoPage = searchPage.selectProduct("Vincent Chase");
		Assert.assertTrue(productInfoPage.productImagesCount() > 0, Errors.IMAGE_COUNT_ERROR_MESSAGE);
		//Assert.assertTrue(productInfoPage.productImagesCount() < 0, Errors.IMAGE_COUNT_ERROR_MESSAGE);
	}
	
	@Test(priority = 3, enabled = false)
	public void getProductTechnicalInfo()
	{
		searchPage = homePage.doSearch("Contact lens");
		productInfoPage = searchPage.selectProduct("Aqualens");
		Map<String, String> productTechnicalInfoMap = productInfoPage.getProductTechnicalInfo();
		productTechnicalInfoMap.forEach((k,v) -> System.out.println(k + " : " + v));
		softAssert.assertEquals(productTechnicalInfoMap.get("Product Id"), "135218");
		softAssert.assertEquals(productTechnicalInfoMap.get("Model No."), "Aqualens Toric Monthly 24 Hours (3 Lens)");
		softAssert.assertAll();
	}
}
