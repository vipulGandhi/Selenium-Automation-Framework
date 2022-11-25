// Problems with running multiple tests(classes) in parallel with one driver instance
	// Threads are dependent on each other
	// Suppose a thread execution is taking more time, a time-out may occur on a different thread which is waiting for the driver.

package com.qa.lenskart.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.google.common.base.Strings;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory
{
	public WebDriver driver;
	public Properties properties;
	public OptionsManager optionsManager;
	public static String highlightElement;
	
	// Threads to get the local copy of WebDriver
	public static ThreadLocal<WebDriver> threadLocal = new ThreadLocal<WebDriver>();
	
	public WebDriver initWebDriver(Properties properties)
	{
		
		String browserName = properties.getProperty("browser").trim().toLowerCase();
		String pageURLString = properties.getProperty("url");
		
		highlightElement = properties.getProperty("highlightElement");
		
		optionsManager = new OptionsManager(properties);
				
		// Initialize the driver
		if(browserName.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			//driver = new ChromeDriver(optionsManager.getChromeOptions());
			threadLocal.set(new ChromeDriver(optionsManager.getChromeOptions()));
		}
		else if(browserName.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			//driver = new FirefoxDriver(optionsManager.getFirefoxoptions());
			threadLocal.set(new FirefoxDriver(optionsManager.getFirefoxoptions()));
		}
		else if(browserName.equals("safari"))
		{
			//driver = new SafariDriver();
			threadLocal.set(new SafariDriver());
		}
		else
		{
			System.out.println("Please pass the correct browser name: " + browserName);
		}
		
		// Preconditions
		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		
		// Launch the browser
		getDriver().get(pageURLString);
		
		return getDriver();
	}
	
	// Return local copy of WebDriver
	public static synchronized WebDriver getDriver()
	{
		return threadLocal.get();
	}
	
	// Initialize properties
	public Properties initProperties()
	{
		properties = new Properties();
		FileInputStream fileInputStream = null;
		
		String environmentString = System.getProperty("environment").trim().toLowerCase(); // dev/ production/ qa/ staging/ uat
		
		if (environmentString.equals("dev") || environmentString.equals("production") || environmentString.equals("qa")
				|| environmentString.equals("staging") || environmentString.equals("uat") || Strings.isNullOrEmpty(environmentString))
		{
			
			if(Strings.isNullOrEmpty(environmentString))
			{
				environmentString = "production";
			}
			
			System.out.println("Running on " + environmentString + " environment ...");
			try
			{
				fileInputStream = new FileInputStream("./src/test/resources/configurations/" + environmentString + ".config.properties");
			}
			catch (FileNotFoundException e)
			{
				e.printStackTrace();
			}
		}
		
		else
		{
			System.out.println("Please enter the correct environment ...");
		}

		try
		{
			properties.load(fileInputStream);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		return properties;
	}
}
