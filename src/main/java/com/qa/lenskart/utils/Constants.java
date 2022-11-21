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
	// ContactLens Search Result Page
	public static final String CONTACT_LENS_PAGE_HEADING = "CONTACT LENS"; 
	public static final int CONTACT_LENS_TOTAL_ITEMS_ON_PAGE = 310; 
	public static final String CONTACT_LENS_PAGE_ITEM_TO_SELECT = "lenskart-lens-spray-and-aqua-drop-combo.html"; 
}
