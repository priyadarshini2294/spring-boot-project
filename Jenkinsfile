pipeline {
    agent any 
    stages {
        stage('Build') {
            steps {
                echo 'Building the code' 
                bat 'mvn clean compile'
            }
        }
    }
}