#!groovy

pipeline {
    agent any

    dir('gp_backend/') {
        stages {
            stage('Build') {
                steps {
                    sh 'pwd'
                    sh 'll'
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
        }
    }
}

