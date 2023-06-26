def call () {
pipeline {
    agent any
    
    stages {
        stage('Compile/Build') {
            steps {
                script {
                }
            }
        }
        
        stage('Test Cases') {
            steps {
                echo 'Test Cases'
            }
        }
    }
  }
}