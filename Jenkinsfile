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
                bat 'mvn sonar:sonar -Dsonar.login=2ea567da5b4cca42385a1ace7ac1154ca598b9d3'
            }
        }
    }
}