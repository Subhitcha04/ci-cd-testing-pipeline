pipeline {
    agent any
    
    tools {
        maven 'Maven 3.9.12'
        jdk 'JDK-17'
        nodejs 'NodeJS'
    }
    
    stages {
        stage('SCM Checkout') {
            steps {
                echo 'Checking out code from GitHub...'
                checkout scm
            }
        }
        
        // ─────────────── JAVA APP ───────────────
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

        stage('Package Java App') {
            steps {
                echo 'Packaging Java application...'
                dir('java-app') {
                    sh 'mvn package -DskipTests'
                }
            }
        }

        stage('SonarQube Analysis - Java') {
            steps {
                echo 'Running SonarQube analysis for Java...'
                withSonarQubeEnv('My Sonar Server') {
                    dir('java-app') {
                        sh '''
                            mvn sonar:sonar \
                              -Dsonar.projectKey=java-app \
                              -Dsonar.projectName="Java App" \
                              -Dsonar.java.binaries=target/classes
                        '''
                    }
                }
            }
        }

        // ★ NEW ★
        stage('Quality Gate - Java') {
            steps {
                echo 'Checking Quality Gate for Java...'
                timeout(time: 3, unit: 'MINUTES') {
                    waitForQualityGate abortPipeline: true
                }
            }
        }

        // ─────────────── NODE APP ───────────────
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
            post {
                always {
                    dir('node-app') {
                        junit 'test-results/*.xml'
                    }
                }
            }
        }

        stage('SonarQube Analysis - Node') {
            steps {
                echo 'Running SonarQube analysis for Node.js...'
                withSonarQubeEnv('My Sonar Server') {
                    dir('node-app') {
                        sh '''
                            sonar-scanner \
                              -Dsonar.projectKey=node-app \
                              -Dsonar.projectName="Node App" \
                              -Dsonar.sources=src \
                              -Dsonar.language=js \
                              -Dsonar.sourceEncoding=UTF-8 \
                              -Dsonar.exclusions=**/node_modules/**,**/test/**,**/*.test.js
                        '''
                    }
                }
            }
        }

        // ★ NEW ★
        stage('Quality Gate - Node') {
            steps {
                echo 'Checking Quality Gate for Node.js...'
                timeout(time: 3, unit: 'MINUTES') {
                    waitForQualityGate abortPipeline: true
                }
            }
        }
    }
    
    post {
        success {
            echo '✅ Pipeline completed successfully! All Quality Gates passed.'
        }
        failure {
            echo '❌ Pipeline FAILED! Quality Gate not passed - deployment blocked.'
        }
        always {
            echo 'Pipeline completed.'
        }
    }
}
