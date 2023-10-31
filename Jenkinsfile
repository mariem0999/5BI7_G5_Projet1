pipeline {
  agent any;
  stages {
    stage("GIT") {
      steps {
        sh 'git checkout master'
        sh 'git pull origin master'
      }
    }
    stage("MAVEN BUILD") {
      steps {
        sh 'mvn clean install -Dmaven.test.skip=true'
      }
    }
    stage("SONARQUBE") {
      steps {
       sh "mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=sonar"
      }
    }
    stage("MOCKITO") {
      steps {
        sh "mvn test -Dtest=tn.esprit.spring.services.InstructorServiceImpMock"
      }
    }

     stage('MVN NEXUS') {
       steps {
               sh 'mvn  deploy -DskipTests  '
               }
     }



  }
}