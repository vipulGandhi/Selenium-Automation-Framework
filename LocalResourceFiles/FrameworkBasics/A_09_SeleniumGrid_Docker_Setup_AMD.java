//Problem: Create an execution environment for parallel testing with different browsers
//Solution: Selenium GRID with Docker Containers

// Selenium GRID Architecture
	// Selenium GRID has one hub connected/ registerd with multiple nodes
		// Hub acts like a server
			// It has it's own ip address and port number
		// Every node is one machine with one OS having a browser with a specific version
	// Setup:
		// Initialize the driver with remote web driver
			// Remote web driver will collect
				// Desired Capabilities
				// Hub url
					// Hub will take the request and transfer the test cases to respective nodes

// Docker Concept
	// Docker engine will be installed on a hardware machine
		// On the top of the hardware machine, we will have an OS(Windows/ OSX/ Linux)
		// On the top of OS, we will install docker engine
			// With the docker engine, Download "N" images on the machine [Every software provides a docker image]
					// Eg. 1 image for selenium hub, 1 image for chrome, 1 image for firefox
					// On each image, crete "M" different docker continers(docker containers are light weight OS)
						// Eg. One 1 chrome image, create 5 chrome containers, each container has a specific version of chrome
						// All the selenium containers are linux containers
						// Every container has it's own OS(Linux) with an app running on it
	// Advantage
		// Free to use
		// Images and Containers are light weight
		// Easy to scale up, scale down
		// Works with Chrome, Firefox, Opera, Edge Browsers
	// Disadvantages
		// Does not support Safari, IE Explorer

// Docker Setup
	// Setup docker engine
		// Download and install Docker Desktop https://docs.docker.com/desktop/install/mac-install/
			// Verify docker version
				// Terminal docker --version
			// Check how many containers are running in docker
				// Terminal docker ps -a
			// Check how many images are running in docker
				// docker images

// Setup docker images, containers from Terminal
	// Pull Images on docker
		// Docker hub [https://hub.docker.com/] is a centralized repo which stores all the software's images
		// Search Selenium hub [https://hub.docker.com/r/selenium/hub]
			// Click Tags [All versions are available]
				// For the latest version, copy pull command "docker pull selenium/hub:latest"
				// Enter command in terminal to get Selenium hub image in the docker engine
		// Search node-chrome-debug [https://hub.docker.com/r/selenium/node-chrome-debug]
			// Click Tags
				// For the latest version, copy pull command "docker pull selenium/node-chrome-debug:latest"
				// Enter command in terminal to get Selenium chrome image in the docker engine
		// Search node-firefox-debug [https://hub.docker.com/r/selenium/node-firefox-debug]
				// For the latest version, copy pull command "docker pull selenium/node-firefox-debug:latest"
				// Enter command in terminal to get Selenium firefox image in the docker engine

	// Run Containers on docker - From Terminal [The commands create the image(if not available) and create the container]
		// Hub Container
			// Terminal: docker run -d -p 4444:4444 --name selenium-hub -P selenium/hub
		// Chrome Container
			// Terminal: docker run -d --link selenium-hub:hub -P selenium/node-chrome-debug
		// Firefox Container
			// Terminal: docker run -d --link selenium-hub:hub -P selenium/node-firefox-debug
				// This command will create one container
				// To create one more container, execute the same command again

// Verify all the containers on Web
	// http://localhost:4444/grid/console OR
	// http://localhost:4444
		// <localhost> kwyword is same as the ip address of local machine
		// If we are using any different machine
			// Replace machine's ip address with localhost
			// Our machine (where the code is written) and the remote machine (where the docker is set up) should be on same network

// Visualize the test cases in docker
	// Download vnc viewer
		// https://www.realvnc.com/en/connect/download/viewer/
	// Suppose we are running the test cases on chrome container
		// Get the local ip and port number on which chrome container is running
			// Go to terminal
				// Run docker ps -a
					// Go to "PORTS" column
					// Copy container's port number <port number>
	// Open VNC viewer
		// In the input column, enter localhost:<port number>
			// Eg. localhost:55005
		// Press enter
		// In the Authentication popup, enter the password: secret

// Execute the code on Docker
	// In config.properties file, Set
		// remote = true
		// huburl = http://localhost:4444/wd/hub
	// Run TestNG Suite OR Terminal: mvn clean install -Denvironment="production"
		// Enjoy the visuals in VNC (page)


// Setup docker images, containers from docker-compose
	// Copy docker-compose-v3.yml file contents from https://github.com/SeleniumHQ/docker-selenium
	// Create docker-compose.yml file (in Sublime text) and paste all the contents
	// Open Terminal
		// cd to the folder where file is saved
		// Check version of docker-compose file
			// docker-compose --version
		// Check if any containers from file are up and running
			// docker-compose ps -a
		// Execute docker-compose.yml file
			// docker-compose up -d

// Scale Up Chrome Container
	// Terminal: docker-compose up -d --scale chrome=4

// Delete all containers
	// Terminal: docker-compose down 

// Delete all images
	// docker system prune -a

// https://javascript.plainenglish.io/selenium-grid-with-docker-compose-b48b5ad8fee2
