#!groovy

pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                sh './mvnw clean install -DskipTests'
            }
        }
        stage('Tests') {
            parallel {
                stage('Running unit tests') {
                    steps {
                        sh './mvnw test -Punit'
                    }
                }
                stage('Running integration tests') {
                    steps {
                        sh './mvnw test -Pintegration'
                    }
                }
            }
        }
        stage('Staging') {
            steps {
                sh 'nohup ./mvnw spring-boot:run -Dserver.port=8001 &'
            }
        }
    }
}

