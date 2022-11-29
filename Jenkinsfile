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
        
        
        
        stage('Test')
        {
            steps
            {
                catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE')
                {
                    git 'https://github.com/vipulGandhi/Automation_Framework.git'
                    sh "mvn clean install"
                }
            }
        }
                
     
        stage('Publish Allure Reports')
        {
           steps
           {
                script
                {
                    allure([
                        includeProperties: false,
                        jdk: '',
                        properties: [],
                        reportBuildPolicy: 'ALWAYS',
                        results: [[path: '/allure-results']]
                    ])
                }
            }
        }
    }
}