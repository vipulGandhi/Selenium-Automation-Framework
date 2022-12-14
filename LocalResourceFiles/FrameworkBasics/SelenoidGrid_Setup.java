// Selenoid Grid is custom docorized grid
	// https://aerokube.com/selenoid/latest/
	// It is a 3rd party tool

// Setup: docker-compose 
	// On a machine where docker is installed, download images of
		// Selenoid Grid/ Selenoid Hub
		// Selenoid UI
			// To visualize the test cases [Integrated VNC Viewer]
			// To check the logs and stats
			// To create a manual session (to perform manual testing)
	// Create container of both images
	// Create a browsers.json file which maintains all the browser versions we need for our test execution
		// Selenoid will read this file and download respective browser images and create the containers
		// Give the path of browser.json file in docker-compose file
