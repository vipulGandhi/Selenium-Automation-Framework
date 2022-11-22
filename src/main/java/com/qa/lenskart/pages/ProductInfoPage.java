/**
 * 
 */
package com.qa.lenskart.pages;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.TreeMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.lenskart.utils.Constants;
import com.qa.lenskart.utils.ElementUtil;
import com.qa.lenskart.utils.PageUtils;
import com.qa.lenskart.utils.WaitUtils;

public class ProductInfoPage
{
	private ElementUtil elementUtil;
	private PageUtils pageUtils;
	private WaitUtils waitUtils;
	
	private String pageHeading;
	private int totalProduceImages;
	private HashMap<String,String> productTechnicalInfoHashMap;
	
	
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
	
	public String getProductBrandName()
	{
		pageHeading = elementUtil.getElementText(pageHeadingBy);
		pageUtils.switchToParentWindow();
		return pageHeading;	
	}
	
	public int productImagesCount()
	{
		totalProduceImages = elementUtil.getElementsCount(waitUtils.isVisibilityOfElementsLocated(productImageCountBy, Constants.DEFAULT_TIME_OUT));
		pageUtils.switchToParentWindow();
		return totalProduceImages;
	}
	
	public HashMap<String, String> getProductTechnicalInfo()
	{
		
		String keyString = null;
		String valueString = null;
		
		// Hash map does not maintain the order
		//HashMap<String,String> productTechnicalInfoHashMap =new HashMap<String,String>();
		
		// Linked HashMap maintains the order in whicj the values are stored
		productTechnicalInfoHashMap =new LinkedHashMap<String,String>();
		
		// Tree Map maintains the order (Sort the keys(and their values) in the ascending order. 1st for Capital letters then for small letters)
		//TreeMap<String, String> productTechnicalInfoHashMap =new TreeMap<String,String>();
		
		elementUtil.doClick(technicalInfoButtonBy);
		
		productTechnicalInfoHashMap.put("Product Name", getProductBrandName());
		
		List<String> productTechnicalMetadataList = 
				elementUtil.getElementsText(waitUtils.isVisibilityOfElementsLocated(productTechnicalInfoMetadataBy, Constants.DEFAULT_TIME_OUT));
		for (int i = 0; i < productTechnicalMetadataList.size(); i++)
		{
			if(i%2 == 0)
			{
				keyString = productTechnicalMetadataList.get(i);
			}
			else
			{
				valueString = productTechnicalMetadataList.get(i);
			}
			productTechnicalInfoHashMap.put(keyString, valueString);
		}
		
		pageUtils.switchToParentWindow();
		return productTechnicalInfoHashMap;
	}
}
