pipeline {
  agent any;
  stages {
    stage("GIT") {
      steps {
        sh 'git checkout MariemEssghaier'
        sh 'git pull origin MariemEssghaier'
      }
    }
    stage("MAVEN BUILD") {
      steps {
        sh 'mvn clean install -Dmaven.test.skip=true'
      }
    }
    stage("MOCKITO") {
          steps {
            sh "mvn test -Dtest=tn.esprit.spring.services.InstructorServiceImpMock"
          }
    }

    stage("SONARQUBE") {
      steps {
       sh "mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=sonar"
      }
    }


     stage('MVN NEXUS') {
       steps {
         sh 'mvn deploy -Dmaven.test.skip=true';
       }
     }

     stage("DOCKER IMAGE") {
        steps {
          sh 'docker build -t mariemessghaier/gestion-station-ski:latest .'
        }
     }
     stage('DOCKER HUB') {
        steps {
          withCredentials([string(credentialsId: 'pass', variable: 'DOCKER_PASSWORD')]) {
            sh '''
                   docker login -u mariemessghaier -p docker_099
                   docker push mariemessghaier/gestion-station-ski
                 '''
          }
        }
     }
     stage('Docker COMPOSE') {
          steps {
                sh 'docker-compose up -d'
          }
     }

     stage('mail') {
         steps {
             emailext(
                 attachLog: true,
                 subject: "Rapport de construction - ${currentBuild.currentResult}",
                 body: "Le pipeline Jenkins a été exécuté avec le statut : ${currentBuild.currentResult}",
                 to: "mariemsgh2@gmail.com"
             )
         }
     }












  }
}