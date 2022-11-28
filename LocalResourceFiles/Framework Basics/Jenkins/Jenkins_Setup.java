// Write the code in working copy
	// Run the test cases either from the working copy(eclipse) or from terminal
	// Browsers are launched in local with sequential/ parallel execution
// Push the code in git repo in main branch
// Setup a jenkins server to trigger the test cases

// Jenkins
	// Jenkins is a CI/CD tool
	// It creates the jobs/ pipeline with multiple configurations to execute the test cases
	// We can generate the report inside jenkins
		// HTML, TestNG, Extent Report, Allure report
	// Jenkins server has it's own ip address and port number
	// Every team/ team member for a project will have a common jenkins server
		// With the given ip address and port number, they can start running the test cases
	// It is Dev-Ops team's responsibility to setup the jenkins

	// Create a job
		// Job configurations
			// Parameterize the job
			// Scheduling/ polling of the job
			// Configure maven and execute maven test cases
			// Integrate with git
				// Setup auto trigger feature
					// Moment the code is pushed in git, it will automatically be triggered for execution

	// Create a declarative pipeline
		// Create jenkins file
		// Declarative pipeline syntax to create a CI/CD pipeline
		// Create an automation pipeline to run the test cases


	

