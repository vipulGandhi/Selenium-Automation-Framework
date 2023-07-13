package FrameworkBasics;
// Include in interview
// Maven is a build automation tool
// Maven Life Cycle
	// 1. Develop the code
	// 2. Compile the code (Use Maven Compiler Plugin)
	// 3. Test/ Run the code (Use Maven Surefire Plugin)
	// 4. Package the code/ Create JAR (Use Maven Assembly Plugin)
	// 5. Deploy the code (Use Maven Deploy Plugin) (Deploy the package in Nexus Location)

// Maven: Plugin vs. Dependency
	// Plugin
		// Plugins are the tools which are used to create a Maven build
			// To compile the project, use maven-compiler-plugin
			// To run the project use maven-surefire-plugin
			// To package the project, use maven-assembly-plugin
			// To deploy the project, use maven-deploy-plugin
	// Dependency
		// Any library/ jar/ war file which we will use in our code execution

//Goal
	// Package the code
	// Convert the project to jar file/ Build the project
// Why to do this
	// Test Automation Center of Exellence (TACOE) creates a common automation framework (CAF) to be used by every team in the company
	// Convert the project to the JAR file and post it on
		// Local company network (nexus repository)
			// Sonatype nexus repository management tool
		// Maven Repository
	// JAR files never includes src/test/java by default

// As we are creating a jar file of the project, the project itself depends on many 3rd party jar files(WebDriverManager, TestNG, Selenium etc.)
	// We create 2 type of jar files for our project
		// Normal JAR [Not preffered]
			// Only create the jar file of the code
			// Does not include 3rd party jar files in the project jar file
			// The developer importing Normal JAR file, has to include other jars in the project's pom.xml file
		// FAT JAR
			// Create project jar file which includes all the 3rd party jar files used in the project

// Setup Process
	// Install docker
		// Windows
			// Terminal
				// https://hub.docker.com/r/sonatype/nexus3/
				// docker run -d -p 8081:8081 --name nexus sonatype/nexus3
		// M1 Mac
			// Terminal
				// https://hub.docker.com/r/klo2k/nexus3
				// docker run -d -p 8081:8081 --name nexus klo2k/nexus3
	// Once installed, open http://localhost:8081/
		// Signin
			// Username: admin
			// Password is located in the nexus docker container
				// Access nexus docker container directory
					// Terminal
						// docker exec -it <container id> cat /nexus-data/admin.password
						//Eg.  docker exec -it 2eaa9bd9c4a1 cat /nexus-data/admin.password
			// Copy the password, enter in http://localhost:8081/
				// Password example: c786128e-9c9c-4a04-9530-b34db763be77
			// Complete the setup
				// Enter new password: Nexus123 [No special characters]
				// Select: Enable anonymous access
		// On the web dashboard, go to settings -> Repositories -> maven-snapshots
			// Copy the URL (http://localhost:8081/repository/maven-snapshots/)
				// Project JAR will be deployed at this url location
			// Go to Eclipse Project
				// Open pom.xml file
				// Add maven-assembly plugin, refresh the project
					// This plugin will help to create project jar file
					// Execute the project from the terminal
						// Terminal
							// cd to project's pom.xml file
							// mvn clean install [Execute maven complete lifecycle]
							// OR, execute
							// mvn clean install -DskipTests=true [Execute complete lifecycle without running the test cases]
					// Maven will create a "target" folder in the project where all the resources will be saved
						// In the target folder, Normal and FAT jar will be created
				// Create maven-deploy plugin
					// This plugin will help us to deploy FAT jar file to above nexus url
					// Add distribution management to pom.xml to tell maven build where to deploy the jar files
					// Execute the project from the terminal
						// Terminal
							// cd to project's pom.xml file
							// mvn deploy package -DskipTests=true
				// Go to http://localhost:8081/ -> Browse -> maven Snapshots/ maven release
					// Observe that a snapshot/ release has been created
					// Click on the version folder
					// Copy the newly created project dependency
					// Share it with the team for them to use your framework
					// When the other team will use your project dependency
						// They do not need to include any other 3rd party dependency (WebDriverManager, TestNG, Selenium etc.)
						// They only need to include your framework dependency as it contains all other dependencies
					// Enjoy !!

// Misc
// A SNAPSHOT version in Maven is the one that has not been released. Before every release version there is a SNAPSHOT version
// Transitive dependencies
	// If we added JUnit as a dependency in pom.xml under <dependencies> tag,
		// It will download the other hamcrest-core-1.3.jar file
			// This hamcrest-core-1.3.jar file is called as Transitive dependency