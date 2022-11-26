// High level overview of framework - [Reference image attached in "Local Resource Files" folder]
	// 1. Create a page layer - Page layer is responsible to perform the actions on the web page
		// Follow SRP - Single responsibility principle
			// Every web-page should have a separate java class
				// WebDriver API's are used in page layer
				// Every page class should have:
					// 1. Private By locator
					// 2. Public page actions/ methods - To access By locator [Encapsulation Concept]
				// For every page, page actions methods need WebDriver to interact with the web elements
			// Never write assertions in page layer

	// 2. Create a DriverFactory class
		// Create a method to initialize the (Thread Local) driver (returns driver)
			// For all the test cases we just have to maintain one single driver having one session id
			// Add functionalities for:
				// Cross browser logic
				// Test cases to be executed locally or remotely
				// Desired Capabilities etc.

								
	// 3. Create configuration data for every environment
		// Create different config.property files
			// Add functionalities for:
				// Which browser to use
				// Which URL to use
				// What is the username
				// What is the password
				// Execute test cases on remote machine or local
				// Weather to use headless mode or not
				// Weather to use incognito or not
				// Weather to highlight the elements or not
		// Let one method "init_property()" in DriverFactory class read all these properties

	// 4. Create TestNG test layer
		// Test layer is used to Assert the actions performed by page layer
		// Never use driver API's in Test layer
		// For every page, create a separate test class
			// Every test class can communicate with different page layer as per the test scenario
			// Every class contains TestNG annotations and assertions
				// Example:
					// Create a loginTest() method
					// It will call loginPage() method of the page class to Assert

	// 5. Create Test base layer
		// Every Test class present in Test layer extends Base class
		// Base layer contains all the pre and post conditions common for every test class
			// @BeforeTest() / @BeforeMethod - Setup()
				// Setup() method will call driver_initialize() method from DriverFactory class to get the driver
					// This driver will be given to the test class method
					// Test class methods, while calling the page class methods, will pass this driver
			// @AfterTest() / @AfterMethod() - TearDown()

	// 6. Create Utilities
		// ElementUtil( actions to be performed by page elements) class should be called by Page layer classes
		// JavascriptUtil
		// ExcelUtil
		// Constants.java
		// Error.java

	// 7. Create Test Data in the form of excel sheets
		// Selenium / Java can't read excel sheet
			// Use Apache POI library
		// Supply the data to the specific test
			// The Test will use the concept of testNG DataProvider
				// @Test will pass the data to the page class methods

	// 8. Reports
		// Selenium does not provide any reporting mechanism
		// Generate reports, logs and screenshots
			// TestNG Report
			// Allure Report
			// Extent Report
			// log4j Logs

	// 9. Test Runner (bunch of testng.xml files to run the test cases)
		// Covers
			// Thread count
			// Test should be run in Sequential or parallel
		// master.xml
		// sanity.xml
		// regression.xml
		
	// 10. Maven
		// The overall project is build as a maven project
		// We have to follow a complete maven 
			// Compile the code
			// Run the code (surefire)
			// Assembly - Generate the jar files
			// Deploy the code on Nexus Repository

// ======= DevOps Integration ==================================================

	// 11. Git integration - Source Code Management
		// Push the code to Git Repo
		// Pull, CheckIn, CheckOut, PR, Merge Request

	// 12. Jenkins Setup
		// Creation of jobs, CI/CD pipeline 
		// Parameterizing the job
		// Scheduling the job
		// Environment configurations
		// NG ROK Proxy - The time the code is pushed to master branch, Jenkins should trigger the test automatically
		// Purpose of jenkins is to get the code from some repository and run the code on some other (execution) environment

	// 13. Docorized grid - Remote environment to run the test cases
		// The test cases should not be run on local machine or jenkins machine
		// Hub, Nodes configuration
		// Docker Grid
		// Compose Grid
		// Zalenium
		// Selenoid Grid
		// Browser Lab

	// 14. AWS - To host/ Set-up Docker Grid
		// EC2 compute linux machine
		// Jenkins to trigger test cases on AWS cloud 

// com/main/java
	// Contains
		// Page Layer
		// Utilities/ Libraries
// com/test/java
	// Contains
		// Test Layer

// Naming Conventions
	// Package name:
		// com.qa.projectname
			// companyname.qa.projectname.componentname
	// Class Name
		// Should be upper CamelCase
	// Method Name, MethodArgument Name
		// Should be lower camelCase




	

			




			

					





