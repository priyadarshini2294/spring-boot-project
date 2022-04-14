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
                bat 'mvn package'
            }
        }
    }
}