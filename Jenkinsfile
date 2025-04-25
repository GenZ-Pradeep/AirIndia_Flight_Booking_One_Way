//
// pipeline {
//     agent any
//     stages {
//         stage('Build') {
//             steps {
//                 //sh 'mvn -B -DskipTests clean package'
//                 //bat "mvn -Dmaven.test.failure.ignore=true clean package
//                 sh 'mvn -Dmaven.test.failure.ignore=true clean package'
//                 //sh 'mvn clean compile'
//             }
//         }
//     }
// }

pipeline {
    agent any

    tools {
        maven 'Maven 3.9.9' // Define your Maven version as configured in Jenkins
        jdk 'JDK 21'        // Define your JDK version as configured in Jenkins
    }

    environment {
        MAVEN_OPTS = "-Xms256m -Xmx512m"
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
            post {
                always {
                    junit '**/target/surefire-reports/*.xml'
                }
            }
        }

        stage('Package') {
            steps {
                sh 'mvn package'
            }
        }

        stage('Archive Artifacts') {
            steps {
                archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
            }
        }
    }

    post {
        success {
            echo 'Build completed successfully!'
        }
        failure {
            echo 'Build failed.'
        }
    }
}
