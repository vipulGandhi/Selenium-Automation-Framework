package FrameworkBasics;
// Setup Jenkins server on a machine [To trigger the execution on a different machine/ cloud]
	// Download LTS jenkins war file
		// https://get.jenkins.io/war-stable/
	// Execute jenkins.war from terminal
		// Open terminal
			// Go to the directory where jenkins.war file is located
				// cd /Users/vipulgandhi/Documents/Vipul/Softwares
			// Execute: java -jar jenkins.war
				// java -jar jenkins.war -httpPort=8081 [If installing on port 8081] OR
				// java -jar jenkins.war --httpPort=8081
			// Copy the password displayed in the terminal
				// The password is also stored at /Users/vipulgandhi/.jenkins/secrets/initialAdminPassword
			// Open a new tab in any browser
				// Enter: localhost:8080 [Replace localhost with the ip address if jenkins is running on a remote machine]
				// Default port number for jenkins is 8080
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

// Trigger the build
	// Go to the dashboard
	// Select the jenkins job
	// Trigger the job
		// Click "Build Now"
			// In the console output, observe:
				// Jenkins will clone the project from git
				// Jenkins will read the pom.xml file
				// Compile the entire code with Maven Compiler plugin
				// Execute with Maven Surefire plugin

// Reports
	// After sucessful builds, reports will be generated
	// Extent HTML report
		// Extent HTML report will be a broken report [broken image links, no proper alignment etc.]
			// This is because of the security policy of jenkins
				// The report contains external images, css
			// Ask the devops team to setup jenkins scp policy OR
			// Download Disable Content-Security-Policy plugin in chrome
				// https://chrome.google.com/webstore/detail/disable-content-security/ieelmcmcagommplceebfedjlakkhpden?hl=en

	// Allure reports will be proper
		// They generate the report from a dedicated server and have a jenkins plugin as well

// To check Jenkins Job workspace [Project code cloned by jenkins from git]
	// Dashboard -> <Job name> -> Workspace

// Autotrigger the test cases
	// The moment we push our code to git, the execution should be triggered from jenkins
	// Setup NGROK proxy [To navigate the events from git repo to jenkins]
		// Create a webhook in the git repository
			// Webhook is a git feature
			// It helps to read git events
			// The webhook will read the git push event and update NGROK proxy
			// NGROK proxy will give the event to Jenkins to trigger the test case
				// NGROK proxy will sit on the same machine on which jenkins is installed
				// It will have same port number which jenkins has [8080 in this case] to communicate with jenkins
	// Setup NGROK proxy [https://www.youtube.com/watch?v=7XgQpb1h9ws]
		// Go to NGROK [https://ngrok.com/download]
			// Sign up
				// On the dashboard page
					// Copy the authentication token [Eg. 7a6fNu36byHoquFRomYLz_4TPkJkSxr6UGDuKGRemt8]
			// Open Terminal
				// Go to the folder where the binary is located
					// cd /Users/vipulgandhi/Documents/Vipul/Softwares
				// Install ngrok
					// brew install --cask ngrok
				// Copy auth token to configuration yml file
					// ngrok authtoken <auth token>
				// Run command
					// ngrok http 8080
						// ngrok window will open in terminal
							// Copy ngrok url value for "forwarding" key
								// [Eg. https://e058-2401-4900-1c8f-e709-5c50-908a-917-4136.in.ngrok.io]
			// NGROK is connected with jenkins through same port number
	// Create Webhook in git repo
		// Go to repository webpage -> Settings -> Webhook -> "Add Webhook"
			// Enter Payload url:
				// <ngrok url value>/github-webhook
					// Eg. https://ff43-2401-4900-1c8f-e709-5c50-908a-917-4136.in.ngrok.io/github-webhook/
			//Click "Add Webhook"
				// Observe "POST /github-webhook/          200 OK " is added in NGROK terminal window
					// If not, go to:
						// https://medium.com/@developerwakeling/setting-up-github-webhooks-jenkins-and-ngrok-for-local-development-f4b2c1ab5b6
	// Setup Jenkins to read NGROK commands/ inputs
		// Go to Jenkins Job -> Configure -> Build Triggers
			// Check "GitHub hook trigger for GITScm polling"

	// Push some changes to git, observe that the test cases are triggered

// Schedule jenkins jobs
	// https://stackoverflow.com/questions/12472645/how-do-i-schedule-jobs-in-jenkins

// Parameterization in jenkins
	// Let jenkins run the project based on different configuration files present in the project
		// (From Terminal) OR (From Jenkins -> Dashboard -> Select job -> Configure -> Builds -> Goals and options)
			// clean install -Denvironment="qa"  :  Run the project with the configurations present in "qa.config.properties" file
			// clean install -Denvironment="dev"  :  Run the project with the configurations present in "dev.config.properties" file
			// clean install -Denvironment="staging"  :  Run the project with the configurations present in "staging.config.properties" file
			// clean install -Denvironment="production"  :  Run the project with the configurations present in "production.config.properties" file
		// Go to Dashboard -> Select job -> Configure -> General
			// Select "This project is parameterized"
				// Click "Add Parameters" -> "Choice Parameter"
					// Enter a key in the "Name" input field (Eg. env)
					// Enter all the values in "Choices" input field
						// Example:
							/*
							 	qa
							 	dev
							 	staging
							 	production
							 */
					// Enter something in the description (Eg. Please select an environment.)
		// Go to Dashboard -> Select job -> Configure -> Build -> Goals and options
			// Set the command: clean install -Denvironment=${env} [env = Key present in name input field]
		// Apply, Save
		// Go to Dashboard -> Select job -> Job dashboard
			// Observe that "Build with Parameters" option is enabled
			// Select "Build with Parameters"
				// Select the environment
				// Click "Build"

// -----------------------------------------------------------------------------------------------------------------
// Create Jenkins Pipeline (CI/CD pipeline)
	// A pipeline has multiple components
		// 1 Dev git repo (Source code management)
			// Build the project [Create jar file]
			// Deploy on Dev environment
			// Trigger unit test cases
		// 2 Deploy on QA environment [Sepertate git repository]
			// Trigger regression test cases
		// 3 Deploy to Staging environment [Sepertate git repository]
			// Trigger UAT test cases
		// 4 Deploy on production environment [Sepertate git repository]
 	// Setup
		// Download blue ocean pipeline plugin
			// Dashboard -> Manage Jenkins -> Manage Plugins
				// Download "Blue Ocean"
				// Install without restart
		// Create declarative pipeline script
			// Go to project -> New -> File
			// Strictly name the file: Jenkinsfile
				// Add the code
				// Push the file to git
		// Dashboard -> New Item
			// Enter an item name (Eg. LensKartQA_Pipeline)
			// Select Pipeline, Click OK
				// Enter description (Eg. This pipeline is used to trigger LensKart test cases)
				// Pipeline -> Select "Pipeline script from SCM"
				// A popup window will open
					// SCM
						// Select GIT
					// Repository Url
						// Enter web url of repository
					// As we have a public repo, we do not have to add credentials
					// Branches to build -> Branch Specifier (blank for 'any')
						// */main
					// Confirm the Script Path
					// Apply, Save
			// Build the pipeline
				// View output in Blue Ocean 

// -----------------------------------------------------------------------------------------------
// Configure email notifications in jenkins
	// https://naveenautomationlabs.com/configuring-email-notification-in-jenkins/
