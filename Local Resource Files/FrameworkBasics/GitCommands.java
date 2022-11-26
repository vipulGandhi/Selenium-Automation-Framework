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
			// Create a snapshot of the working copy, add it to git stage
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
			// 








// Untracked files: Files which still needs to be committed
	
