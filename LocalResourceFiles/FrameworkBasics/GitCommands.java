// First Commit Process
	// Create a git repo
	// Push the code to repo
	// Login to git, create a repo
	// Install git on local machine
		// brew install git
	//	Verify if git is installed
		// git --version
	// Open terminal
		// Go to project's present working directory
			// cd /Users/vipulgandhi/Documents/Vipul/Automation/Projects/Automation_Framework
		// Initialize working copy with git
			// git init
				// .git directory(hidden) will be created in the project 
		// Check if the .git directory is created inside the project
			// ls -alt
				// It displays all the files present in present working directory
		// Connect local project to repo
			// git remote add origin https://github.com/vipulGandhi/Selenium_Automation_Framework.git
		// Check status of local/ working copy (how many files are pending/ pushed/ committed)
			// git status
	// Add .gitignore file in the project
		// Git ignores the files present in .gitignore to upload them to the repository
		// Go to project
		// Right click -> Create a new file with name: .gitignore
		// Add all the files to ignore
	// Come back to terminal
		// Check status of local/ working copy (how many files are pending/ pushed/ committed)
			// git status
				// Number of files to commit will be reduced
		// Add all the untracked files to git stage
			// git add .
				// Create a snapshot of the working copy(complete project), add it to git stage
		// Check status of local/ working copy (how many files are pending/ pushed/ committed)
			// git status
				// All files are ready to be committed now
		// Commit
			// git commit -m "Commit"
				// -m is the commit message
			// Files are now reached to local repository
		// Push
			// git push origin master OR git push origin main
				// master/ main is the name of root directory
				// 1st commit goes to master branch
			// Enter username: vipulgandhi10@gmail.com
			// Enter password/ passphrase
				// Go to git dashboard
				// Click on Avatar -> Click settings -> Click Developer Settings
				// Generate a new classic token [Select all scopes]
				// Enter token 
	// Check the code at remote side
		// Code is pushed in the master branch

// Nth Commit Process
	// Update/ Create/ Delete files in the project
	// Open terminal
		// Go to project's present working directory
			// cd /Users/vipulgandhi/Documents/Vipul/Automation/Projects/Automation_Framework
		// Check status of local/ working copy (how many files are pending/ pushed/ committed)
			// git status
		// Add all the untracked files to git stage
			// git add <filename>
				// Only add the updated/ created files
		// Commit
			// git commit -m "Commit"
				// -m is the commit message
		// Push
			// git push origin master OR git push origin main
				// master/ main is the name of root directory
		// Display all the commits in console
			// git log
			// press "q" to come out 
			// git log --oneline
				// display consize report
			// press "q" to come out

// Git branching
	// Open terminal
		// Go to project's present working directory
			// cd /Users/vipulgandhi/Documents/Vipul/Automation/Projects/Automation_Framework
		// Get all the branches present in local
			// git branch
				// [Output] * main
					// "*" means the branch local working copy is pointing to
		// Get last commit on current branch
			// git branch -vv
		// From the master branch present in local, get a new/ feature branch in local
			// git branch branch_vipul_gandhi
				// git branch <branchname>
		// Get all the branches present in local
			// git branch
		// Switch the branch to branch_vipul_gandhi branch
			// git checkout branch_vipul_gandhi
		// Get all the branches present in local
			// git branch
		// Make some changes in the project
			// The changes will be reflected in branch_vipul_gandhi branch
		// Check status of local/ working copy (how many files are pending/ pushed/ committed)
			// git status
		// Add all the untracked files to git stage
			// git add <filename>
				// Only add the updated/ created files
		// Commit
			// git commit -m "Commit"
				// -m is the commit message
		// Push
			// git push origin master OR git push origin main
				// master/ main is the name of root directory


	

	

	
	








// Untracked files: Files which still needs to be committed
	
