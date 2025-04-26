pipeline {
    agent any

    tools {
        maven 'Maven3'   // Make sure "Maven3" is configured in Jenkins
        jdk 'JDK21'      // Make sure "JDK21" is configured in Jenkins
    }

    environment {
        PLAYWRIGHT_SKIP_BROWSER_DOWNLOAD = '1' // Optional: if you want to manage Playwright browsers manually
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Install Playwright Browsers') {
            steps {
                sh 'mvn exec:java -e -Dexec.mainClass="com.microsoft.playwright.CLI" -Dexec.args="install"'
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
        }
    }

    post {
        always {
            junit '**/target/surefire-reports/*.xml'
        }
    }
}
