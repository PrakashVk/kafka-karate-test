pipeline {
	agent any

    tools {
		maven 'Maven_3.8.3'
        jdk 'OpenJDK11'
    }

    environment {
		KARATE_OPTIONS = 'classpath:features/kafka-test.feature'
    }

    stages {
		stage('Build') {
			steps {
				sh 'mvn clean install'
            }
        }

        stage('Run Karate Tests') {
			steps {
				sh 'mvn test -Dkarate.options="${KARATE_OPTIONS}"'
            }
        }

        stage('Publish Results') {
			steps {
				junit '**/target/surefire-reports/*.xml'
            }
        }
    }
}
