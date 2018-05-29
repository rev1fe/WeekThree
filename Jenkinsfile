pipeline {
  agent any
  stages {
    stage('BUILD') {
      parallel {
        stage('BUILD') {
          steps {
            sh './gradlew build'
          }
        }
        stage('TEST') {
          steps {
            sh './gradlew test'
          }
        }
        stage('Check') {
          steps {
            sh './gradlew check'
          }
        }
      }
    }
    stage('Message') {
      steps {
        echo 'Successfully passed'
      }
    }
  }
}