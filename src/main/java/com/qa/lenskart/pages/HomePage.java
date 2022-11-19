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

public class HomePage
{
	private WebDriver driver;
	private ElementUtil elementUtil;
	private WaitUtils waitUtils;
	private JavascriptUtil javascriptUtil;
	private ActionsUtil actionsUtil;
	
	private By userNameBy = By.xpath("(//div[@class='login-panel']/div)[1]");
	private By loginPanelItemsBy = By.xpath("//div[@class='login-panel']//a[@class='dropdown-list']");
	private By logoutLinkBy = By.xpath("//div[@class='login-panel']//a[text()='Logout']");
	private By searchBy = By.xpath("//input[@name='q']");
	
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
		waitUtils = new WaitUtils(driver);
		javascriptUtil = new JavascriptUtil(driver);
		actionsUtil = new ActionsUtil(driver);
	}
	
	public String getUserName()
	{
		return elementUtil.getElementText(waitUtils.isVisibilityOfElementLocated(userNameBy, Constants.DEFAULT_TIME_OUT));
	}
	
	public List<String> getLoginPanelItems()
	{
		actionsUtil.doMoveToElement(userNameBy);
		System.out.println(elementUtil.getElementsText(waitUtils.isVisibilityOfElementsLocated(loginPanelItemsBy, Constants.DEFAULT_TIME_OUT)));
		return elementUtil.getElementsText(waitUtils.isVisibilityOfElementsLocated(loginPanelItemsBy, Constants.DEFAULT_TIME_OUT));
	}
	
	public boolean isSearchExist()
	{
		return elementUtil.isElementDisplayed(searchBy);
	}
	
	public void doSearch(String productName)
	{
		if(isSearchExist())
		{
			elementUtil.doSendKeys(searchBy, productName);
			elementUtil.pressEnter(searchBy);
		}
	}
	
	public void doLogout()
	{
		actionsUtil.doMoveToElement(userNameBy);
		elementUtil.doClick(waitUtils.ifElementVisibleAndClickable(logoutLinkBy, Constants.DEFAULT_TIME_OUT));
		javascriptUtil.waitForPageLoaded();
	}
}
