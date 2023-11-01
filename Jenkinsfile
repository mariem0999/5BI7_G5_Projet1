pipeline {
  agent any;
  stages {
    stage("GIT") {
      steps {
        sh 'git checkout master'
        sh 'git pull origin master'
      }
    }
    stage('MVN CLEAN') {
       steps {
        sh 'mvn clean';
       }
    }

    stage('MVN COMPILE') {
        steps {
          sh 'mvn compile';
        }
    }
    stage("SONARQUBE") {
      steps {
       sh "mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=sonar -Dmaven.test.skip=true";
      }
    }
    stage("MOCKITO") {
      steps {
        sh "mvn test -Dtest=tn.esprit.spring.services.InstructorServiceImpMock";
      }
    }

     stage('MVN NEXUS') {
       steps {
         sh 'mvn deploy -Dmaven.test.skip=true';
       }
     }



  }
}