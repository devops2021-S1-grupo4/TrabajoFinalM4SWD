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

        stage("Levantar Springboot APP"){
            steps {
                sh 'mvn spring-boot:run &'
                sh 'nohup bash java -jar Lab4.jar & >/dev/null'
            }
        }
        stage("Dormir(Esperar 40sg) "){
            steps {
               sh "sleep 40"
            }
        }

        stage('Test WS -postman') {
            steps {
                sh "newman run ./src/test/postman/Dxc.postman_collection.json"
            }
        }

        // stage('Test Jmeter') {
        //     steps {
        //         sh "mvn verify -Pperformance"
        //     }
        // }
    }
}