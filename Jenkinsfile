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
    stages {
        stage('Build') {
            steps {
                sh 'mvn clean compile'
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
