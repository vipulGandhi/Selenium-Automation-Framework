package com.qa.lenskart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.lenskart.utils.ActionsUtil;
import com.qa.lenskart.utils.Constants;
import com.qa.lenskart.utils.ElementUtil;
import com.qa.lenskart.utils.JavascriptUtil;
import com.qa.lenskart.utils.PageUtils;
import com.qa.lenskart.utils.WaitUtils;

public class ContactLensesPage
{
	
	private WebDriver driver;
	private ElementUtil elementUtil;
	private WaitUtils waitUtils;
	private JavascriptUtil javascriptUtil;
	private PageUtils pageUtils;

	public ContactLensesPage(WebDriver driver)
	{
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
		waitUtils = new WaitUtils(driver);
		javascriptUtil = new JavascriptUtil(driver);
		pageUtils = new PageUtils(driver);
	}

	//private By pageHeadingBy = By.xpath("//h1[text()='Contact Lens']");
	private By searchResultCountBy = By.xpath("//div[@class='show_count']");
	private By productToSelect = By.xpath("//div[text()='Lenskart PLUS']");
	
	
	public String getHeading(String pageHeading)
	{
		By pageHeadingBy = By.xpath("//h1[text()='"+pageHeading+"']");
		
		System.out.println("Heading: " + elementUtil.getElementText(waitUtils.isPresenceOfElementLocated(pageHeadingBy, Constants.DEFAULT_TIME_OUT)));
		return elementUtil.getElementText(waitUtils.isVisibilityOfElementLocated(pageHeadingBy, Constants.DEFAULT_TIME_OUT));
	}
	
	public int getTotalProductsAvailableCount()
	{
		String resultString = 
				elementUtil.getElementText((waitUtils.isPresenceOfElementLocated(searchResultCountBy, Constants.DEFAULT_TIME_OUT)));
		return Integer.parseInt(resultString.split(" ")[3]);
	}
	
	private int getTotalProductsDisplayedCount()
	{
		String resultString = 
				elementUtil.getElementText((waitUtils.isPresenceOfElementLocated(searchResultCountBy, Constants.DEFAULT_TIME_OUT)));
		return Integer.parseInt(resultString.split(" ")[1]);
	}
	
	public ProductInfoPage selectProduct(String productName)
	{
		while (elementUtil.getElements(productToSelect).size() <=0 && getTotalProductsDisplayedCount() < getTotalProductsAvailableCount())
		{
			javascriptUtil.scrollByPixel("1");
			
			if(elementUtil.getElements(productToSelect).size() == 1)
			{
				System.out.println("Product Found");
				elementUtil.doClick(productToSelect);
				pageUtils.switchToChildWindow();
				break;
			}
		}
		return new ProductInfoPage(driver);
	}
}
