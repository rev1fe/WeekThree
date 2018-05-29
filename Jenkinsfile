pipeline {
  agent any
  stages {
    stage('Test') {
      steps {
        sh './gradlew check'
      }
    }
    stage('Message') {
      steps {
        echo 'Successfully passed'
      }
    }
  }
}