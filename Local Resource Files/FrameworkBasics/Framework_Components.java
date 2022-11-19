
// Framework Design/ Architecture
	// To segregate the code into multiple separate components. The components then integrate with each other to create a framework
// Framework should:
	// Be generic in nature
	// Require less maintenance
	// Avoid hard-code values
	// Avoid Duplicate code
	// Create different layers of components

// Hybrid Framework Architecture
	// 1. Page Object Model design pattern
	// 2. Create a test layer
		// To write the test cases in TestNG
	// 3. Create custom Utilities/ Libraries/ Generic functions
		// Eg. ElementUtil, JavascriptUtil, ExcelUtil
	// 4. 3rd party libraries
		// Selenium 
		// WebdriverManager
		// Extent report, allure report etc.
	// 5. HTML reports generation
		// Extent report : Web report
		// Allure Report
		// TestNG HTML report
	// 6. TestNG Listeners
		// To generate reports
	// 7. log4j for logging
	// 8. Maintain the test and configuration data
		// Use Data Driven Approach to:
			// Drive data from excel sheets
			// Use properties file
			// TestNG parameters, data providers
	// 9. Maintain environment specific configuration properties
	// 10. QA/ Dev/ Staging/ Prod 
	// 11. SRP - Single Responsibility Principle
		// Each class will have individual responsibility only
	// 12. Dev ops
			// Docker Container: Docorized Grid for infrastructure
				// Docker Grid
				// Compose Grid
				// Zalenium
				// Selenoid Grid
				// Browser Lab
			// Jenkins: For CI/CD
				// Single Job
				// Job Pipeline (Blue ocean pipeline)
			// Github to maintain the repo
				// Integrate git with jenkins
			// NG ROK: Proxy server
				// To trigger the test cases via. jenkins
				// It will pick the test cases and instruct jenkins to trigger the test cases automatically
			// AWS Cloud: To host the docker grid [AWS compute service: EC2 linux machine]
				// Selenium grid to run on AWS
				// Run and push the test cases to AWS docker grid
			// Eclipse
	// 13. Page chaining model	