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
                git 'https://github.com/vipulGandhi/Automation_Framework.git'
                sh "mvn clean install"
            }
        }
        
        
    }
}