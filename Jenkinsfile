pipeline {
    agent any
    stages {
        /* "Build" and "Test" stages omitted */
        stage('Build') {
            steps {
                git branch: 'dev', url : 'https://github.com/GayathriDevops/library_backend.git'
            }
        }
        stage('maven_goals_and_options') {
            steps {
                sh "/opt/maven/bin/mvn clean install sonar:sonar"
            }
        }
        
        stage('java backend application') {
            steps {
                sh "export JENKINS_NODE_COOKIE=dontKill; nohup java -jar $WORKSPACE/target/INGSuite.jar &"
            }
        }
    }
}
