pipeline {
    agent any

    tools {
        maven 'maven'
        jdk 'jdk-21'
    }

//     environment {
//         PLAYWRIGHT_SKIP_BROWSER_DOWNLOAD = '1' // Optional: if you want to manage Playwright browsers manually
//     }

    stages {
//         stage('Checkout') {
//             steps {
//                 echo 'Checkout'
//                 checkout scm
//             }
//         }

//         stage('Install Playwright Browsers') {
//             steps {
//             //sh ia used for Linux/Unix, bat is used for windows
//             echo 'Install Playwright Browsers'
//                // bat 'mvn exec:java -e -Dexec.mainClass="com.microsoft.playwright.CLI" -Dexec.args="install"'
//             }
//         }

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

//      post {
//          always {
//              junit '{basedir}/target/surefire-reports/TEST-*.xml'
//
//          }
//      }
}
