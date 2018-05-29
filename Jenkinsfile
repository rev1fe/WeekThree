pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        sh 'gradlew build'
      }
    }
    stage('Test') {
      steps {
        sh 'gradlew test'
      }
    }
    stage('Message') {
      steps {
        echo 'Successfully passed'
      }
    }
  }
}