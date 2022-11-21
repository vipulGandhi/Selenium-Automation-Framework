/**
 * 
 */
package com.qa.lenskart.pages;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.lenskart.utils.Constants;
import com.qa.lenskart.utils.ElementUtil;
import com.qa.lenskart.utils.JavascriptUtil;
import com.qa.lenskart.utils.PageUtils;
import com.qa.lenskart.utils.WaitUtils;

public class ProductInfoPage
{
	private ElementUtil elementUtil;
	private PageUtils pageUtils;
	private WaitUtils waitUtils;
	
	private String pageHeading;
	private HashMap<String, String> productTechnicalInfoHashMap;
	
	By pageHeadingBy = By.xpath("//div[contains(@class,'product-brands')]");
	By productImageCountBy = By.xpath("//div[@class='product-images-list']//li");
	By technicalInfoButtonBy = By.xpath("//span[text()='Technical Information']");
	By productTechnicalInfoMetadataBy = By.xpath("//span[text()='Technical Information']/../../following-sibling::div//span[contains(@class,'info-text')]");
	
	public ProductInfoPage(WebDriver driver)
	{
		elementUtil = new ElementUtil(driver);
		pageUtils = new PageUtils(driver);
		waitUtils = new WaitUtils(driver);
	}
	
	public String getPageHeading()
	{
		pageHeading = elementUtil.getElementText(pageHeadingBy);
		pageUtils.switchToParentWindow();
		return pageHeading;	
	}
	
	public int productImagesCount()
	{
		return elementUtil.getElementsCount(waitUtils.isVisibilityOfElementsLocated(productImageCountBy, Constants.DEFAULT_TIME_OUT));
	}
	
	public HashMap<String, String> getProductTechnicalInfo()
	{
		elementUtil.doClick(technicalInfoButtonBy);
		List<String> productTechnicalMetadataList = 
				elementUtil.getElementsText(waitUtils.isVisibilityOfElementsLocated(productTechnicalInfoMetadataBy, Constants.DEFAULT_TIME_OUT));
		for (int i = 0; i < productTechnicalMetadataList.size(); i++)
		{
			
		}
	}
}
