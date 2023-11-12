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
              script {
                def windowsPath = 'D:/WorkIntellij/projet1/docker-compose.yml'
                def unixPath = windowsPath.replaceAll('\\', '/')
                sh "docker compose -f ${unixPath} up"
                sh "docker compose -f ${unixPath} start"
              }
          }
     }










  }
}