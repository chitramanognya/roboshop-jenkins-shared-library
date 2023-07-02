def call () {
    if (!env.sonar_extra_opts) {
        env.sonar_extra_opts= ""
    }
pipeline {
    agent any
    
    stages {
        stage('Compile/Build') {
            steps {
                sh 'env'
                script {
                common.compile()
            }
        }
        
       }
        stage('Test Cases') {
            steps {
                script {
                common.testcases()
            }
        }
    }
    
    stage('Code Quality') {
            steps {
                script {
                common.codequality()
            }
        }
    }
 }

post {
   failure {
       mail body: '${component} - pipeline Failed \n ${BUILD_URL}', from: 'chmanu.chinu@gmail.com', subject: '${component} - pipeline Failed', to: 'chmanu.chinu@gmail.com'
   }  
  }


 }
}