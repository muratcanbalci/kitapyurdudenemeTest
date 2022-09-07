pipeline {
  agent {
    node {
      label 'windows'
    }

  }
  stages {
    stage('Control POM') {
      parallel {
        stage('Control POM') {
          steps {
            fileExists 'pom.xml'
          }
        }

        stage('Control to Versions') {
          steps {
            bat 'java --version'
            bat 'git --version'
          }
        }

      }
    }

    stage('Clean') {
      steps {
        bat 'mvn -DskipTests clean'
      }
    }

    stage('Compile') {
      steps {
        bat 'mvn -DskipTests compile'
      }
    }

  }
}