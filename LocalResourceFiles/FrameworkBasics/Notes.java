package FrameworkBasics;
// Hybrid Framework with POM design pattern -
	// Page Object Model
		// POM is a design pattern
		// POM follows SRP(Single Responsibility Principle)
			// For every webpage, we create a seperate Java class
		// Never use assertions in page class
		// Page actions should provide page behaviours
		// Encapsulation
			// By locators should be private and should be accessed via public page actions
		// Use a test client to test (eg. TestNG/ JUnit/ PyTest/ Jasmine/ Mocha/ NUnit)
		// Assertions should be written only in test classes
		// Never use driver api's in test classes

	// In the framework We are using Data Driven Approach for some of the test cases which require data from excel sheets
	// We are using Libraries
		// Created a lot of generic utility classes and package
	// We are not using any keyword driven Approach [Legacy]
		// Keyword Driven Approach
			// 1. Open Browser
			// 2. Enter url
			// 3. Enter username (Use data driven approach)
			// 4. Enter password (Use data driven approach)
			// 5. Click on login
				// For every of the above action, we create a seperate method.
					// We have to arrange the methods in the same sequence
					// We have to arrange the sequence in an excel sheet
	// We use TDD(Test driven development) approach
		// Test cases for each functionality are created and tested first
		// If the test fails then the new code is written in order to pass the test and making code simple and bug-free.
		// Example:
			// Complete the login page (the login page contains the functionality of sign in)
			// Successful sign in, the page redirects to home page
			// The Home Page class reference is required in Login Page sign in function for successful validation
				// [Need arise to create a functionality]
			// Create a HomePage class

