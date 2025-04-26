pipeline {
    agent any

    tools {
        maven 'maven'
        jdk 'jdk-21'
    }

    stages {

        stage('Build') {
            steps {
                echo 'Build'
                bat 'mvn clean compile install'
            }
        }

        stage('Run Specific Test') {
            steps {
                echo 'Run Specific Test'
                bat 'mvn clean test -Dtest=com.ai.steps.TestRunnerAIOWB'

            }
        }
    }
}
