pipeline {
    agent any 
    stages {
        stage('Build') {
            steps {
                echo 'Building the code' 
                bat 'mvn clean'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing the code' 
                bat 'mvn test'
            }
        }
        stage('compile') {
            steps {
                echo 'compiling the code' 
                bat 'mvn compile'
            }
        }
        stage('Generate Jar') {
            steps {
                echo 'Generating runnable jar' 
                bat 'mvn install'
            }
        }
        
        stage('Static code analysis with sonar') {
            steps {
                echo 'Started SonarQube Analysis' 
            	withSonarQubeEnv('sonarQube'){
            		 bat 'mvn sonar:sonar -Dsonar.login=ff14baf9ae260180cbc3ed6696d768607d70aa71'
            	}
            }
        }
    }
}