//Problem: Create an exection environment for parallel testing with different browsers
//Solution: Selenium GRID with Docker Containers/ Machine

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
						// Eg. One 1 chrome image, create 5 chrome containers, each container contains a specific version of chrome
						// All the selenium containers are linux containers
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
		// Download software(s) images from docker hub [docker pull]
			// Docker hub [https://hub.docker.com/] is a centralized repo which stores all the software's images
				// Search Selenium hub [https://hub.docker.com/r/selenium/hub]
					// Click Tags
						// Search for Selenium 3.141.59
							// Copy pull command "docker pull selenium/hub:3.141.59-20210929"
					// Go to Terminal
						// Pull Selenium Hub Image
							// docker pull selenium/hub:3.141.59-20210929
				// Search node-chrome-debug [https://hub.docker.com/r/selenium/node-chrome-debug]
					// Click Tags
						// Search for node-chrome-debug 3.141.59
							// Copy pull command "docker pull selenium/node-chrome-debug:3.141.59"
					// Go to Terminal
						// Pull node-chrome-debug Image
							// docker pull selenium/node-chrome-debug:3.141.59
				// Search node-firefox-debug [https://hub.docker.com/r/selenium/node-firefox-debug]
					// Click Tags
						// Search for node-firefox-debug 3.141.59
							// Copy pull command "docker pull selenium/node-firefox-debug:3.141.59"
					// Go to Terminal
						// Pull node-firefox-debug Image
							// docker pull selenium/node-firefox-debug:3.141.59
		// Create container(s) on the image[docker run : pull the image(if not available) and create the container]
			// To create multiple containers(of chrome & firefox) for parallel testing, execute Container's :docker run: command again 
			// Create Hub container
				// Terminal: docker run -d -p 4444:4444 --name selenium-hub -P selenium/hub:3.141.59      
			// Create Chrome node container
				// Terminal: docker run -d --name selenium-node-chrome-01  --link selenium-hub:hub -P selenium/node-chrome-debug
			// Create Firefox node container
				// Terminal: docker run -d --name selenium-node-firefox-01  --link selenium-hub:hub -P selenium/node-firefox-debug
			// docker run command
				// If we execute "docker run" without "docker pull", it will execute "docker pull" first then it will create the container
				// Prefer downloading containers, images will be downloaded automatically
		// Verify all the containers on Web
			// http://localhost:4444/grid/console OR
			// http://localhost:4444
				// <localhost> kwyword is same as the ip address of local machine
				// If we are using any different machine
					// Replace machine's ip address with localhost
					// Our machine (where the code is written) and the remote machine (where the docker is set up) should be on same network







		// Remove a container
			// Get the container id from terminal
				// docker ps -a
			// Stop the container
				// docker stop <container id>
			// Remove the container
				// docker rm <conteiner id>
		// Remove a image
			// Get the image id from terminal
				// docker images
			// Remove all the containers from the image
			// Remove the image
				// docker rmi <image id>
		// Remove all stopped containers, images
			// docker system prune -a

 		// For M1 Mac
			// https://github.com/seleniumhq-community/docker-seleniarm
			// Create Chrome Container
				// docker run --rm -it -p 4444:4444 -p 5900:5900 -p 7900:7900 --shm-size 2g seleniarm/standalone-chromium:latest
			// Create Firefox Container
				// docker run --rm -it -p 4444:4444 -p 5900:5900 -p 7900:7900 --shm-size 2g seleniarm/standalone-firefox:latest


	
// Docker Compose
	// Copy docker-compose-v3.yml file contents from https://github.com/SeleniumHQ/docker-selenium [AMD version]
	// Create docker-compose.yml file (in Sublime text) and paste all the contents
	// Open Terminal
		// cd to the folder where file is saved
		// Check version of docker-compose file
			// docker-compose --version
		// Check if any containers from file are up and running
			// docker-compose ps -a
		// Execute docker-compose.yml file
			// docker-compose up -d

	
			





	// Setup Docker GRID/ Dockerized GRID
	// Setup Docker compose GRID
	// Setup Zalenium
	// Setup browser lab with Selenoid GRID [Host Selenoid GRID on AWS machine]
