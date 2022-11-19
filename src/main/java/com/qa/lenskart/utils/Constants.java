package com.qa.lenskart.utils;

import java.util.ArrayList;
import java.util.List;

public class Constants
{
	
	//--------------------------------------------------------------------------------------
	// Global
	public static final int DEFAULT_TIME_OUT = 5;
	
	// Login Page
	public static final String lOGIN_PAGE_TITLE_FRACTION = "Quora - A place to share knowledge";  
	public static final String lOGIN_PAGE_URL_FRACTION = "quora.com";  
	public static final String lOGIN_PAGE_HEADING = "A place to share knowledge and better understand the world";  
	
	//--------------------------------------------------------------------------------------
	// Home Page
	public static final String HOME_PAGE_TITLE = "Quora"; 
	
	public static List<String> quoraSpaces()
	{
		List<String> quoraSpacesStrings = new ArrayList<String>();
		
		quoraSpacesStrings.add("Science");
		quoraSpacesStrings.add("Food");
		quoraSpacesStrings.add("Health");
		quoraSpacesStrings.add("Movies");
		quoraSpacesStrings.add("Technology");
		
		return quoraSpacesStrings;
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
