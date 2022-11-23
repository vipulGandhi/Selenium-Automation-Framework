package com.qa.lenskart.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory
{
	public WebDriver driver;
	public Properties properties;
	public OptionsManager optionsManager;
	public static String highlightElement;
	
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
			driver = new ChromeDriver(optionsManager.getChromeOptions());
		}
		else if(browserName.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver(optionsManager.getFirefoxoptions());
		}
		else if(browserName.equals("safari"))
		{
			driver = new SafariDriver();
		}
		else
		{
			System.out.println("Please pass the correct browser name: " + browserName);
		}
		
		// Preconditions
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		// Launch the browser
		driver.get(pageURLString);
		
		return driver;
	}
	
	// Initialize properties
	public Properties initProperties()
	{
		properties = new Properties();
		
		try
		{
			// . signifies - From the current project directory
			FileInputStream fileInputStream = new FileInputStream("./src/test/resources/configurations/config.properties");
			properties.load(fileInputStream);
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		return properties;
	}
}
