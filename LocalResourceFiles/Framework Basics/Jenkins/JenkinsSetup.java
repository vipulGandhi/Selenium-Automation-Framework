// Setup Jenkins server on your machine [To trigger the execution on a different machine/ cloud]
	// Download LTS jenkins war file
		// https://get.jenkins.io/war-stable/
	// Execute jenkins.war from terminal
		// Open terminal
			// Go to the directory where jenkins.war file is located
				// cd /Users/vipulgandhi/Documents/Vipul/Softwares
			// Execute: java -jar jenkins.war
			// Copy the password displayed in the terminal
				// The password is also stored at /Users/vipulgandhi/.jenkins/secrets/initialAdminPassword
			// Open a new tab in any browser
				// Enter: localhost:8080 [Replace localhost with the ip address if jenkins is running on a remote machine]
				// Default port number for jenkins is 8080
					// If 8080 is in use, execute: java -jar jenkins.war -httpPort=8081 
				// Jenkins configuration setup will start
					// Unlock Jenkins page: Enter the password
					// Customize Jenkins page: Click "Install suggested plugins" 
						// Jenkins server is started
						// Data is getting downloaded, progress is displayed on UI and in terminal [Do not close terminal]

// Configure Jenkins
	// Dashboard -> Manage Jenkins -> Global tool configuration
		// Setup JAVA_HOME path
			// Click on "Add JDK" button
			// A popup will open
			// Uncheck "Install Automatically"
			// Enter JDK name (eg. JDK17.0.5LTS)
			// Enter JAVA_HOME path
				// Prerequisite
					// Java is installed on the machine
						// Terminal: java -version
					// JAVA_HOME path is configured
						// Terminal: echo $JAVA_HOME [Copy the path]
		// Setup MAVEN_HOME path
			// Click on "Add Maven" button
			// A popup will open
			// Enter Maven name (eg. ApacheMaven3.8.6)
			// Check "Install Automatically", select the latest version
			// Apply, Save
	// Dashboard -> Manage Jenkins -> Manage Plugins -> Available plugins
		// Install testNG [Install without restart]
		// Install Maven Integration [Install without restart]
		// Install HTML Publisher [Install without restart]
		// Install Allure [Install without restart]
			// Once the plugin is installed, configure the plugin in global tool configuration
				// Go to: Dashboard -> Manage Jenkins -> Global tool configuration
				// Click "Add Allure Commandline"
				// A popup will open
				// Enter Allure name (eg. Allure2.20.1)
				// Check "Install Automatically", select the latest version
				// Apply, Save 

// Create a jenkins job
	// Go to Dashboard -> New Item
		// Enter an item name (eg. LenskartQA)
		// Select Maven Project
		// Click OK
		// Configuration -> General page will open
			// Give a Description (eg. "This job is used to trigger LensKart automation test cases.")
			// Source Code Management
				// Select Git
					// Click "Add Repository" 
						// Enter repo web url (eg. https://github.com/vipulGandhi/Automation_Framework)
					// "Add Credentials" will only work if the repository is private
						// Our's is a pubic repository
					// Select the branch from which we want to trigger our test cases (eg. */main)
			// Build
				// Root pom
					// Confirm the pom.xml path in the project [If we have changed pom.xml path during maven project creation]
			// Goals and Options
				// Enter maven terminal command which executes the project
					// clean install
						// Actual maven terminal command: mvn clean install
							// Jenkins take mvn automatically
			// Post build actions
				// Click "Add post build actions"
					// Select: "Publish TestNG Results"
					// Select: "Allure Report"
					// Select: "Publish HTML reports"
						// Click "Add"
							// HTML directory to archive [Select the directory in the project where the report will be available]
								// Enter "build" in the input box
									// We created the build folder in the project to get extent reports
							// Index page[s] [Enter file name]
								// Enter "TestExecutionReport.html" in the input box
							// Report title [Enter title of the generated report]
								//Enter "Extent HTML Report"
							// Click "Publishing Options"
								// Select: "Keep past HTML reports"
		// Apply, Save
			// Go to Dashboard, observe that the Job has been created



							
							



			





						

