pipeline 
{
    agent any
    tools
    {
        maven 'maven'
    }

    stages 
    {
        stage('QATest')
        {
            steps
            {
                git 'https://github.com/vipulGandhi/Automation_Framework11.git'
                sh "mvn clean install"
            }
        }
        
        
    }
}