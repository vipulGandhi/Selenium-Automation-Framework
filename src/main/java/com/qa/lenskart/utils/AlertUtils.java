/*
We switch back to main window or default content after switching to a new window or frame,
but not in case of Alert even we are switching to it.

When we switch to a new window or frame, we jump to another DOM.
A new window is also a DOM and a frame is also a DOM inside a DOM
This is the reason, when we switch to them using selenium methods, it returns a WebDriver.
When work is done in new DOM, we need to switch back to parent window.
 
In case of alert (JavaScript alert) is not a new DOM.
When we switch to an alert, it returns a reference of type “Alert”.
We perform desired action and proceed further without switching back as it is not required.
*/

package com.qa.lenskart.utils;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

public class AlertUtils
{
	
	WebDriver driver;
	Alert alert;
	
	public AlertUtils(WebDriver driver)
	{
		this.driver= driver;
	}

	public boolean isAlertPresent() 
	{ 
	    try 
	    { 
	    	alert = driver.switchTo().alert(); 
	        return true; 
	    }
	    catch (NoAlertPresentException Ex) 
	    { 
	        return false; 
	    }
	}
	
	public void acceptAlert()
	{
		if(isAlertPresent())
			alert.accept();
	}
	
	public void dismissAlert()
	{
		if(isAlertPresent())
		{
			System.out.println("Dismiss Alert ===");
			alert.dismiss();
		}
			
	}
	
	public String getAlertText()
	{
		if(isAlertPresent())
			return alert.getText();
		return null;
	}
	
	public void setAlertText(String alertText)
	{
		if(isAlertPresent())
			 alert.sendKeys(alertText);
	}
}
