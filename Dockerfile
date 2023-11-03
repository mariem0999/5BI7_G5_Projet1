FROM openjdk:11-jdk
EXPOSE 8089
ADD target/5bi7-g5-gestion-station-ski.jar  mhamedfray-5bi7-g5-gestion-station-ski.jar
ENTRYPOINT ["java","-jar","/mhamedfray-5bi7-g5-gestion-station-ski.jar"]
