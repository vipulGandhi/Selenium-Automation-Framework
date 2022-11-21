/**
 * 
 */
package com.qa.lenskart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.lenskart.utils.ElementUtil;
import com.qa.lenskart.utils.JavascriptUtil;
import com.qa.lenskart.utils.WaitUtils;

/**
 * @author vipulgandhi
 *
 */
public class ProductInfoPage
{
	private WebDriver driver;
	private ElementUtil elementUtil;
	private WaitUtils waitUtils;
	private JavascriptUtil javascriptUtil;
	
	
	public ProductInfoPage(WebDriver driver)
	{
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
		waitUtils = new WaitUtils(driver);
		javascriptUtil = new JavascriptUtil(driver);
	}
}
