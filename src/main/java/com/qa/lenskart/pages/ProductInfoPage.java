/**
 * 
 */
package com.qa.lenskart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.lenskart.utils.ElementUtil;
import com.qa.lenskart.utils.JavascriptUtil;
import com.qa.lenskart.utils.PageUtils;
import com.qa.lenskart.utils.WaitUtils;

public class ProductInfoPage
{
	private ElementUtil elementUtil;
	private PageUtils pageUtils;
	
	private String pageHeading;
	
	By pageHeadingBy = By.xpath("//div[contains(@class,'product-brands')]");
	
	public ProductInfoPage(WebDriver driver)
	{
		elementUtil = new ElementUtil(driver);
		pageUtils = new PageUtils(driver);
	}
	
	public String getPageHeading()
	{
		pageHeading = elementUtil.getElementText(pageHeadingBy);
		pageUtils.switchToParentWindow();
		return pageHeading;
		
	}
}
