package com.qa.lenskart.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.lenskart.utils.ActionsUtil;
import com.qa.lenskart.utils.Constants;
import com.qa.lenskart.utils.ElementUtil;
import com.qa.lenskart.utils.JavascriptUtil;
import com.qa.lenskart.utils.WaitUtils;

public class ContactLensesPage
{
	private WebDriver driver;
	private ElementUtil elementUtil;
	private WaitUtils waitUtils;
	private JavascriptUtil javascriptUtil;
	private ActionsUtil actionsUtil;
	
	private By pageHeadingBy = By.xpath("//h1[text()='Contact Lens']");
	private By searchResultCountBy = By.xpath("//div[@class='show_count']");
	private By allListedProducts = By.xpath("//div[@class='product-name']");

	public ContactLensesPage(WebDriver driver)
	{
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
		waitUtils = new WaitUtils(driver);
		javascriptUtil = new JavascriptUtil(driver);
		actionsUtil = new ActionsUtil(driver);
	}
	
	public String getHeading()
	{
		return elementUtil.getElementText(waitUtils.isPresenceOfElementLocated(pageHeadingBy, Constants.DEFAULT_TIME_OUT));
	}
	
	public int getSearchResultCount()
	{
		String resultString = 
				elementUtil.getElementText((waitUtils.isPresenceOfElementLocated(searchResultCountBy, Constants.DEFAULT_TIME_OUT)));
		return Integer.parseInt(resultString.split(" ")[3]);
	}
	
	public void selectProduct(String productName)
	{
		List<WebElement> allElements = driver.findElements(allListedProducts);
		
		for (WebElement webElement : allElements)
		{
			
		}
	}
}
