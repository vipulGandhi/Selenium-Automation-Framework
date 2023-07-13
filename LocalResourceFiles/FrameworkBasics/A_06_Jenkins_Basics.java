package FrameworkBasics;
// Write the code in working copy(Eclipse)
	// Run the test cases either from the working copy or from terminal
	// Browsers are launched in local with sequential/ parallel execution
// Push the code in git repo in main branch
// Setup a jenkins server to trigger the test cases
	// Create a job
		// Job configurations
			// Parameterize the job
			// Scheduling/ polling of the job
			// Configure maven and execute maven test cases
			// Integrate with git
				// Setup auto trigger feature
					// Moment the code is pushed in git, it will automatically be triggered for execution
	// When the job is triggered
		// Jenkins will integrate with the git repo branch
		// It will pick the code from git to local and create a workspace (clone the project)
		// The browser will be launched on jenkins machine
			// Not a good practice
				// All the teams/ team members are using common jenkins server
					// The browser(when triggered) needs to finish 1st task before jumping to the next one
			// Setup the execution environment on a different machine or on cloud [Let the browser be launched there]

// Jenkins
	// Jenkins is a CI/CD tool
	// It creates the jobs/ pipeline with multiple configurations to execute the test cases
	// We can generate the report inside jenkins
		// HTML, TestNG, Extent Report, Allure report
	// Jenkins server has it's own ip address and port number
	// Every team/ team member for a project will have a common jenkins server
		// With the given ip address and port number, they can start running the test cases
	// It is Dev-Ops team's responsibility to setup the jenkins


	// Create a declarative pipeline
		// Create jenkins file
		// Declarative pipeline syntax to create a CI/CD pipeline
		// Create an automation pipeline to run the test cases
		// https://www.lambdatest.com/blog/jenkins-declarative-pipeline-examples/


	

