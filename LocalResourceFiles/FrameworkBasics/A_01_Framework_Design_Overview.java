// Framework Design/ Architecture
	// To divide the code into multiple separate components. The components then integrate with each other to create a framework
// Framework should:
	// Be generic in nature
	// Require less maintenance
	// Avoid hard-code values
	// Avoid Duplicate code
	// Create different layers of components

// High level overview of hybrid framework architecture - [Reference image attached in "Local Resource Files" folder]
	// 1. Create a page layer (Follow Page Object Design Pattern) - Page layer is responsible to perform the actions on the web page
		// Follow SRP - Single responsibility principle
			// Every web-page should have a separate java class
				// WebDriver API's are used in page layer
				// Every page class should have:
					// 1. Private By locator (representing web-elements)
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
				
	// 3. Create configuration data for every environment [Data Driven Approach]
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
		// Drive data from excel sheets
		// TestNG parameters, data providers

	// 4. Create TestNG test layer
		// Test layer is used to Assert the actions performed by page layer
		// Never use driver API's in Test layer
		// Assertions should be written only in test classes
		// For every page, create a separate test class
			// Every test class can communicate with different page layer as per the test scenario - Use Page chaining model
			// Every class contains TestNG annotations and assertions
				// Example:
					// Create a loginTest() method
					// It will call loginPage() method of the page class to Assert

	// 5. Create Test base layer
		// Every Test class present in Test layer extends Base class
		// Base layer contains all the pre and post conditions common for every test class
			// @BeforeTest() - Setup()
				// Setup() method will call driver_initialize() method from DriverFactory class to get the driver
					// This driver will be given to the test class method
					// Test class methods, while calling the page class methods, will pass this driver to the object of page class
			// @AfterTest() - TearDown()

	// 6. Create custom Utilities/ Libraries/ Generic functions
		// ElementUtil( actions to be performed by page elements) class should be called by Page layer classes
		// JavascriptUtil
		// ExcelUtil
		// RestAssured Wrapper Methods
		// JsonParseUtil
		// ReportingUtils
		// DatabaseUtil
		// Constants.java
		// Error.java

	// 7. Create Test Data in the form of excel sheets
		// Data Driven Approach for some of the test cases which require data from excel sheets
		// Selenium / Java can't read excel sheet
			// Use Apache POI library
		// Supply the data to the specific test
			// The Test will use the concept of TestNG DataProvider
				// @Test will pass the data to the page class methods
		// We are not using any keyword driven Approach [Legacy]
			// Keyword Driven Approach
				// 1. Open Browser
				// 2. Enter url
				// 3. Enter username (Use data driven approach)
				// 4. Enter password (Use data driven approach)
				// 5. Click on login
					// For every of the above action, we create a seperate method
						// We have to arrange the methods in the same sequence
						// We have to arrange the sequence in an excel sheet

	// 8. Reports
		// Selenium does not provide any reporting mechanism
		// Generate reports, logs and screenshots
			// TestNG Report - TestNG Listener
			// Allure Report
			// Extent Report - Web Reports
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
		// We have to follow a complete maven lifecycle
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

	// 13. Dockerized grid - Remote environment to run the test cases
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
