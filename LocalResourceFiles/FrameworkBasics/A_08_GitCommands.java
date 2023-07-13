// Git: Source Code Management Tool
// Resource: https://learngitbranching.js.org/

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
			// git checkout branch_vipul_gandhi OR git switch branch_vipul_gandhi
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
			// git push origin branch_vipul_gandhi
				// Git will create branch_vipul_gandhi branch on remote
		// A PR(Pull Request) flag will be generated on repository web page
			// Creare a PR for a merge from branch_vipul_gandhi -> main
		// On web repository, Click on "Pull Requests"
			// Go to "Files Changed" to comment on the PR (if any)
			// Go to "Conversation", Merge the pull request
		// Go to the local main branch
			// git checkout main OR git switch main
				// The changes made in local branch_vipul_gandhi is not reflected in local main branch
		// Get updates from remote main branch in local main branch
			// git pull origin main
		

// --- Git Branching Process -----
	// Developer1 create a folder structure on local machine
	// Developer1 push the code to local stage [git add .]
	// Developer1 commit the code to local repo [git commit -m "message"]
	// Developer1 push the code to master branch
	
	// Developer2 clone the project in their local
		// Cloning process:
			// Create a folder <myfolder> in local
			// Open terminal
			// cd to the created folder
				// Let the present working directory be the created folder
			// git clone <repo url>
		// Import the project in eclipse
	// Developer2 cut the local main branch (Eg. Developer2_branch)
		// Eclipse working copy points to Developer2_branch
	// Developer2 make some changes in the project
	// Developer2 push the code to local stage [git add <filename>]
	// Developer2 commit the code to local repo [git commit -m "message"]
	// Developer2 push the code to Developer2_branch remote branch
		// Raise a PR
	
	// Merge main <- Developer2_branch
		// Remote main branch is updated

	// Developer1 takes the pull from remote main branch to it's Developer1 local branch 

// Delete remote branch
	// git push -d origin <branchname>
// Delete local branch
	// git branch -d <branchname>

// Tag a branch
	// Switch to main branch
		// git checkout main
	// Optional
		// Add all the untracked files to git stage
			// git add <filename>
				// Only add the updated/ created files
		// Commit
			// git commit -m "Commit"
				// -m is the commit message
	// Add tag to the commit
		// git tag v1.0
	// Push to remote with tag
		// git push origin v1.0
	// On web dashboard, go to the tag index table
		// Select a tag (eg. v1.1)
		// Create Release From the Tag
			// Release the feature(all the commits)
	// Get number of tags for this branch
		// git tag
	// delete a tag from local
		// git tag -d <tag name>

// Merge Conflicts
	// Somebody has updated the remote branch [Eg. added a file <myFile>]
	// We have also added a file with the same file name in our local working copy
		//	File is in our local, We have not commit our file till now
	// We take a pull from remote branch
		// No merge conflicts will occur
			// We have to abort our file to successfully complete the pull
	// We have commit our file
	// We take a pull from remote branch
		// A merge conflict will occur
			// Resolve the conflict
				// Resolve the conflict in local file [Eclipse -> Project -> myFile]
				// Add file to git stage
					// git add <myFile>
				// Commit
					// git commit -m "Commit"
						// -m is the commit message
				// Push
					// git push origin <branch name>
				// The other person has to pull the code and abort his changes
			// Stash our code to git memory [put our code in a safe space][Scenario: Take other person's code in our local to verify it's code]
				// git stash
				// take a successfil pull from remote branch [No merge conflicts will occur]
				// Take the stash code in again in our local branch
					// git stash pop
					// merge conflict will occur
						// Resolve the conflicts

// Delete commit from local
	// Suppose we have commit something to our local repo
		// Update something in the local
		// Add to stage
		// Commit to local repo
	// We want to delete this commit
		// Delete from local repo
			// git reset --soft HEAD^
				// The latest commit will be deleted from loal repo
		// Delete from stage
			// git reset --mixed HEAD^
	// Check git status
		// The files again becomes untracked
			// Untracked files: Files which are in local working directory only
		// Delete from Local repo, stage and from local working copy
			//  git reset --hard HEAD^

// Delete commit from remote repo
	// Suppose we have commit something to our remote repo
		// Do hard reset
			// git reset --hard HEAD^
		// Force push the delete to remote repo
			// git push -f origin <branchname>
