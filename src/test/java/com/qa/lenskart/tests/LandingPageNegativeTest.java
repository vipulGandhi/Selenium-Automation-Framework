package com.qa.lenskart.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LandingPageNegativeTest extends BaseTest
{
	@DataProvider
	public Object[][] invalidEmailData()
	{
		Object[][] invalidCredentialsObject = new Object[2][1];
		
		invalidCredentialsObject[0][0] = "wrongusername@gmail.com";
		invalidCredentialsObject[1][0] = "badusername@gmail.com";
		
		return invalidCredentialsObject;	
	}
	
	@Test(priority = 1, dataProvider = "invalidEmailData")
	public void loginNegativeTest(String usernameString)
	{
		Assert.assertTrue(landingPage.doSignInWithInvalidEmail(usernameString));
	}
}
