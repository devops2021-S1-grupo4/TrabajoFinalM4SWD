pipeline {
    agent any
    stages {
        stage('Clean') {
            steps {
                sh "mvn clean"
            }
        }

        stage('Compile') {
            steps {
                sh "mvn compile"
            }
        }

        stage('Test') {
            steps {
                sh "mvn test"
            }
        }

        stage('Test WS -postman') {
            steps {
                sh "newman run Dxc.postman_collection.json"
            }
        }

        stage('Test Jmeter') {
            steps {
                sh "mvn verify -Pperformance"
            }
        }
    }
}