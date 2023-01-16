#!groovy

pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                sh './mwnv clean install -DskipTests'
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
                sh "pid=\$(lsof -i:8989 -t); kill -TERM \$pid || kill -KILL \$pid"
                withEnv(['JENKINS_NODE_COOKIE=dontkill']) {
                    sh 'nohup ./mvnw spring-boot:run -Dserver.port=8989 &'
                }
            }
        }
//         stage('Build Docker image') {
//             steps {
//
//             }
//         }
//         stage('Push Docker Image') {
//             steps {
//
//             }
//         }
    }
}
//postgres
//app
//
//docker run -itd -e POSTGRES_USER=postgres /
//-e POSTGRES_PASSWORD=mysecretpassword /
//-e POSTGRES_DB=gp /
//-p 5432:5432
//--name postgresql_main
//postgres

//docker stop postgresql_main
//docker rm postgresql_main

//declarative or imperative ?

//declarative - pipeline
//scripted    - node

