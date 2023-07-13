package com.qa.lenskart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;

import com.qa.lenskart.listeners.AllureReportListener;
import com.qa.lenskart.utils.Constants;
import com.qa.lenskart.utils.ElementUtil;
import com.qa.lenskart.utils.JavascriptUtil;
import com.qa.lenskart.utils.WaitUtils;

import io.qameta.allure.Epic;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import net.bytebuddy.asm.Advice.This;

@Epic("Jira Epic id: Design LensKart UI - Landing Page")
@Story("User Story id: LensKart Page Design With Multiple Features")

// If we are not getting screenshots in the allure report, add @Listeners
@Listeners(AllureReportListener.class)
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
	private By passwordBy = By.xpath("//input[@title='password']");
	private By proceedButtonBy = By.xpath("//div[@class='auth-modal-login-container ']//span[text()='Sign In']");
	private By invalidEmilMsgBy = By.xpath("//div[@class='custom-error-msg']");
	private By invalidCredentialsMsgBy = By.xpath("//div[@class='sign-in-error-msg']");
	
	public LandingPage(WebDriver driver)
	{
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
		waitUtils = new WaitUtils(driver);
		javascriptUtil = new JavascriptUtil(driver);
	}
	
	
	@Step("Getting page title")
	public boolean isTitlePresent()
	{
		return waitUtils.ifTitleContainsText(Constants.lANDING_PAGE_TITLE_FRACTION, Constants.DEFAULT_TIME_OUT);
	}
	
	@Step("Getting page url")
	public boolean isUrlPresent()
	{
		return waitUtils.ifUrlContainsText(Constants.lANDING_PAGE_URL_FRACTION, Constants.DEFAULT_TIME_OUT);
	}
	
	@Step("Getting logo")
	public boolean isLogoDisplayed()
	{
		return elementUtil.isElementDisplayed(logoBy);
	}
	
	@Step("Sign in with valid email: {0} and password: {1} and navigating to home page")
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
	
	@Step("Sign in with invalid email: {0}")
	public boolean doSignInWithInvalidEmail(String email)
	{
		if(elementUtil.isElementDisplayed(pushNotificationDismissBy))
		{
			elementUtil.doClick(pushNotificationDismissBy);
		}

		elementUtil.doClick(waitUtils.ifElementVisibleAndClickable(signInLinkBy, Constants.DEFAULT_TIME_OUT));

		elementUtil.doSendKeys(waitUtils.ifElementVisibleAndClickable(emailBy, Constants.DEFAULT_TIME_OUT), email);

		elementUtil.doClick(proceedButtonBy);

		String errorMsg = elementUtil.getElementText(waitUtils.isPresenceOfElementLocated(invalidEmilMsgBy, Constants.DEFAULT_TIME_OUT));
		if(errorMsg.contains(Constants.EMAIL_ERROR_MESSAGE))
		{
			return true;
		}
		return false;
	}
}
