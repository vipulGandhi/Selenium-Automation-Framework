package com.qa.lenskart.utils;

import java.util.ArrayList;
import java.util.List;

public class Constants
{
	
	//--------------------------------------------------------------------------------------
	// Global
	public static final int DEFAULT_TIME_OUT = 5;
	
	// Landing Page
	public static final String lANDING_PAGE_TITLE_FRACTION = "Lenskart.com";  
	public static final String lANDING_PAGE_URL_FRACTION = "lenskart.com";  
	
	//--------------------------------------------------------------------------------------
	// Home Page
	public static List<String> loginPanelItems()
	{
		List<String> loginPanelItemsString = new ArrayList<String>();
		
		loginPanelItemsString.add("My Orders");
		loginPanelItemsString.add("My Prescription");
		loginPanelItemsString.add("My Store Credit");
		loginPanelItemsString.add("My Dittos");
		loginPanelItemsString.add("Account Information");
		loginPanelItemsString.add("Logout");
		
		return loginPanelItemsString;
	}
	
	//--------------------------------------------------------------------------------------
	// Search Result Page
	public static final String SEARCH_PAGE_TITLE = "Search"; 
	
	public static List<String> SearchAllTypesLinks()
	{
		List<String> searchAllTypesLinksStrings = new ArrayList<String>();
		
		searchAllTypesLinksStrings.add("Questions");
		searchAllTypesLinksStrings.add("Answers");
		searchAllTypesLinksStrings.add("Posts");
		searchAllTypesLinksStrings.add("Profiles");
		searchAllTypesLinksStrings.add("Topics");
		searchAllTypesLinksStrings.add("Spaces");
		
		return searchAllTypesLinksStrings;
	}
	
}
