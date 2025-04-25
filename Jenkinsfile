
pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                //sh 'mvn -B -DskipTests clean package'
                //bat "mvn -Dmaven.test.failure.ignore=true clean package
                sh "mvn -Dmaven.test.failure.ignore=true clean package
            }
        }
    }
}

