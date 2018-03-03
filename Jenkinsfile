pipeline {
    agent { docker 'maven:3.3.9' }
	tools { 
        jdk 'jdk8' 
    }
    stages {
        stage('build') {
            steps {
                sh 'mvn --version'
				sh 'mvn clean install'
            }
			post {
                success {
                    junit 'target/surefire-reports/**/*.xml' 
                }
            }
        }
    }
}