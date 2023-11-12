FROM openjdk:11-jdk
ARG JAR_URL
EXPOSE 8089
ADD $JAR_URL mhamedfray-5bi7-g5-gestion-station-ski.jar
ENTRYPOINT ["java","-jar","/mhamedfray-5bi7-g5-gestion-station-ski.jar"]
