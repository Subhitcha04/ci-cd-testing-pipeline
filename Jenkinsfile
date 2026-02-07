pipeline {
    agent any
    
    stages {
        stage('SCM Checkout') {
            steps {
                echo 'Checking out code from GitHub...'
                checkout scm
            }
        }
        
        stage('Build Java App') {
            steps {
                echo 'Building Java application...'
                dir('java-app') {
                    sh 'mvn clean compile'
                }
            }
        }
        
        stage('Test Java App') {
            steps {
                echo 'Running Java tests...'
                dir('java-app') {
                    sh 'mvn test'
                }
            }
            post {
                always {
                    junit 'java-app/target/surefire-reports/*.xml'
                }
            }
        }
        
        stage('Build Node App') {
            steps {
                echo 'Building Node.js application...'
                dir('node-app') {
                    sh 'npm install'
                }
            }
        }
        
        stage('Test Node App') {
            steps {
                echo 'Running Node.js tests...'
                dir('node-app') {
                    sh 'npm test'
                }
            }
        }
    }
    
    post {
        success {
            echo 'Pipeline completed successfully! All tests passed.'
        }
        failure {
            echo 'Pipeline failed. Check the logs for details.'
        }
    }
}
```

## **Option 2: Separate Jenkinsfiles for Each App**

If you want separate pipelines, create two Jenkinsfiles:
```
ci-testing-demo/
├── java-app/
│   └── Jenkinsfile      # ← For Java app only
└── node-app/
    └── Jenkinsfile      # ← For Node.js app only