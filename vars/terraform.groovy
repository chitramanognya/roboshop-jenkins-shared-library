def call() {
    pipeline {
      agent any    
      
      parameters {
          string(name: 'ENV', defaultValue: '', description: 'Which Environment?')
          string(name: 'ACTION', defaultValue: '', description: 'Which Action?')
          
          
      }
      
      options {
          ansicolor('xterm')
      }
      stages {
          
          stage('init') {
              steps {
                  
                  sh 'terraform init -backend-config=env-${ENV}/state.tfvars'
              }
          }
          
          stage('apply') {
              steps {
                 // sh 'terraform ${ACTION} -auto-approve -var-file=env-dev/main.tfvars'
              
                  sh 'echo'
              }
          }
      }  
    }
    
}