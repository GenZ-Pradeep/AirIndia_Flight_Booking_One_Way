
pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                //sh 'mvn -B -DskipTests clean package'
                sh  "mvn -Dmaven.test.failure.ignore=true clean package"
                //sh 'mvn clean compile'
                //sh 'mvn clean compile'
            }
            post
            {
                success
                {
                    junit '**/target/surefire-reports/TEST-*.xml'
                    archiveartifacts 'target/*.jar'
                }
            }
        }
    }
}
