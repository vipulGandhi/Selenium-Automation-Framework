package com.qa.lenskart.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HelloTest extends BaseTest
{
	
	@BeforeClass
	public void test()
	{
		homePage = landingPage.doSignIn(properties.getProperty("email"), properties.getProperty("password"));
		System.out.println(properties.getProperty("url"));
	}
	
	@Test
	public void sample()
	{
		System.out.println(properties.getProperty("url"));
		System.out.println("New Sample");
	}
}
