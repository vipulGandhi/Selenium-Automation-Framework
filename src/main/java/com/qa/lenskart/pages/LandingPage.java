package com.qa.lenskart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.lenskart.utils.Constants;
import com.qa.lenskart.utils.ElementUtil;
import com.qa.lenskart.utils.JavascriptUtil;
import com.qa.lenskart.utils.WaitUtils;

import net.bytebuddy.asm.Advice.This;

public class LandingPage
{
	private WebDriver driver;
	private ElementUtil elementUtil;
	private WaitUtils waitUtils;
	private JavascriptUtil javascriptUtil;
	
	private By logoBy = By.xpath("//div[@class='logo']");
	private By signInLinkBy = By.xpath("//span[text()='Sign In']");
	private By pushNotificationDismissBy = By.xpath("//button[text()='No thanks']");
	private By emailBy = By.xpath("//input[@name='emailOrPhone']");
	private By passwordBy = By.xpath("//input[@name='password']");
	private By proceedButtonBy = By.xpath("//button[text()='Proceed']");
	
	public LandingPage(WebDriver driver)
	{
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
		waitUtils = new WaitUtils(driver);
		javascriptUtil = new JavascriptUtil(driver);
	}
	
	public boolean isTitlePresent()
	{
		return waitUtils.ifTitleContainsText(Constants.lANDING_PAGE_TITLE_FRACTION, Constants.DEFAULT_TIME_OUT);
	}
	
	public boolean isUrlPresent()
	{
		return waitUtils.ifUrlContainsText(Constants.lANDING_PAGE_URL_FRACTION, Constants.DEFAULT_TIME_OUT);
	}
	
	public boolean isLogoDisplayed()
	{
		return elementUtil.isElementDisplayed(logoBy);
	}
	
	public HomePage doSignIn(String email, String password)
	{
		if(elementUtil.isElementDisplayed(pushNotificationDismissBy))
		{
			elementUtil.doClick(pushNotificationDismissBy);
		}

		elementUtil.doClick(waitUtils.ifElementVisibleAndClickable(signInLinkBy, Constants.DEFAULT_TIME_OUT));

		elementUtil.doSendKeys(waitUtils.ifElementVisibleAndClickable(emailBy, Constants.DEFAULT_TIME_OUT), email);

		elementUtil.doClick(proceedButtonBy);

		elementUtil.doSendKeys(waitUtils.ifElementVisibleAndClickable(passwordBy, Constants.DEFAULT_TIME_OUT), password);
		elementUtil.doClick(proceedButtonBy);

		javascriptUtil.waitForPageLoaded();
		
		return new HomePage(driver);
	}
}
