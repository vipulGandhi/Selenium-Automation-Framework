pipeline 
{
    agent any
    tools
    {
        maven 'maven'
    }

    stages 
    {
        stage('Build') 
        {
            steps 
            {
                 git 'https://github.com/vipulGandhi/Maven-Project-With-Test.git'
                 sh "mvn -Dmaven.test.failure.ignore=true clean package"
            }
        }
    }
}