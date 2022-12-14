// Selenoid Grid is custom docorized grid
	// https://aerokube.com/selenoid/latest/
	// It is a 3rd party tool

// Setup: docker-compose 
	// Concept
		// On a machine where docker is installed, download images of
			// Selenoid Grid/ Selenoid Hub
			// Selenoid UI
				// To visualize the test cases [Integrated VNC Viewer]
				// To check the logs and stats
				// To create a manual session (to perform manual testing)
		// Download browser.json from https://github.com/vipulGandhi/Automation_Framework/tree/main/Selenoid_Files
			// browsers.json file maintains all the browser versions we need for our test execution
			// Selenoid will read this file and download respective browser images and create the containers
			// Give the path of browser.json file in docker-compose file
		// Download docker-compose file from https://github.com/vipulGandhi/Automation_Framework/tree/main/Selenoid_Files
			// Every image in docker-compose file is connected with Selenoid Hub and Selenoid UI

	// Open Terminal
		// cd to the path where both files are located
		// Create selenoid network
			// docker network create <network name>
				// Eg. docker network create selenoid
			// Network name should be same as the network name defined in docker-compose file
		// Execute docker-compose file
			// docker-compose up -d
