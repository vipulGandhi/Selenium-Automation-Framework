// Run project from terminal
	// 1. Right Click Project -> Properties -> Copy project location
	// 2. Check if java is installed
		// java -version
	// 3. Check if JAVA_HOME path is set correctly
		// echo $JAVA_HOME
		// https://www.youtube.com/watch?v=Kq3ppMu2iuk
		// https://www.youtube.com/watch?v=hRThN2gal6U&t=390s
	// 4. Install homebrew
		// https://stackoverflow.com/questions/66666134/how-to-install-homebrew-on-m1-mac
	// 5. Install Maven
		// The command "brew install maven" will install the latest Maven and will set MAVEN_HOME path
		// https://mkyong.com/maven/install-maven-on-mac-osx/
	// 5. Add testng.xml configuration in surefire plugin in pom.xml file
	// 6. Open Terminal
		// Go to the project path where pom.xml is present
			// cd /Users/vipulgandhi/Documents/Vipul/Automation/Projects/Automation_Framework
	// 7. Run command mvn clean install -Denvironment="qa"
		// -Denvironment="qa" = -Dkey="value"
			// We have set the key-value pairs in DriverFactory class
				// Key = "environment" [ System.getProperty("environment").trim().toLowerCase();]
				// Value = All possible values "environment" could have
					// "dev", "production", "qa", "staging", "uat"
		// Maven will start running all the test cases
	// 8. Run command mvn clean install
		// This command will keep the environment value to null
			// If environment value is null, the test cases will run in QA environment
				// Ref: DriverFactory class
	// 9. Run command mvn clean install -Denvironment="qa" -Dexcel="qa"
		// The test will run in qa environment
		// The test will take the data from "LensKartTestDataSheet_qa.xlsx" sheet
			// Ref: ExcelUtil.java

// Misc
	// To run only failed test cases again
		// https://dzone.com/articles/jenkins-testng-failed-test-cases-for-maven#:~:text=Copy%20or%20move%20the%20failed,to%20run%20the%20failed%2Dtestng.


		