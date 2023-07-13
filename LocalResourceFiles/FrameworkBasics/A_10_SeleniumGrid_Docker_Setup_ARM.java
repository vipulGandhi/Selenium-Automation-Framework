// For Mac Machines With M1, M2 chips
// Reference
	// https://hub.docker.com/u/seleniarm
	// https://github.com/seleniumhq-community/docker-seleniarm

// Setup docker images, containers from docker-compose
	// Get docker-compose.yml file from https://github.com/vipulGandhi/Automation_Framework/blob/main/docker-compose.yml
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