pipeline {
    agent any
    stages {
        stage('Test') {
            steps {
                bat "mvn test"
            }
          stage('Run Postman'){
              bat "newman run Test_lab4.postman_collection.json"
          }
        }
    }
}