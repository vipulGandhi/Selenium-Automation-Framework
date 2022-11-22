package com.qa.lenskart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.lenskart.utils.ActionsUtil;
import com.qa.lenskart.utils.Constants;
import com.qa.lenskart.utils.ElementUtil;
import com.qa.lenskart.utils.JavascriptUtil;
import com.qa.lenskart.utils.PageUtils;
import com.qa.lenskart.utils.WaitUtils;

public class SearchPage
{
	
	private WebDriver driver;
	private ElementUtil elementUtil;
	private WaitUtils waitUtils;
	private JavascriptUtil javascriptUtil;
	private PageUtils pageUtils;

	public SearchPage(WebDriver driver)
	{
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
		waitUtils = new WaitUtils(driver);
		javascriptUtil = new JavascriptUtil(driver);
		pageUtils = new PageUtils(driver);
	}

	private By searchResultCountBy = By.xpath("//div[@class='show_count']");
	
	
	public String getHeading(String pageHeading)
	{
		// Why this By locator is present in a method body
			// The value of By locator is not constant. It is getting updated with the method parameters
		By pageHeadingBy = By.xpath("//h1[text()='"+pageHeading+"']");
		return elementUtil.getElementText(waitUtils.isVisibilityOfElementLocated(pageHeadingBy, Constants.DEFAULT_TIME_OUT));
	}
	
	public int getTotalProductsAvailableCount()
	{
		String resultString = 
				elementUtil.getElementText((waitUtils.isPresenceOfElementLocated(searchResultCountBy, Constants.DEFAULT_TIME_OUT)));
		return Integer.parseInt(resultString.split(" ")[3]);
	}
	
	public ProductInfoPage selectProduct(String productName)
	{		
		By productToSelect = By.xpath("//div[text()='"+productName+"']");
		elementUtil.doClick(waitUtils.ifElementVisibleAndClickable(productToSelect, Constants.DEFAULT_TIME_OUT));
		pageUtils.switchToChildWindow();
		javascriptUtil.waitForPageLoaded();

		return new ProductInfoPage(driver);
	}
}
