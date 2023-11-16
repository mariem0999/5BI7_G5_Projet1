FROM openjdk:11
WORKDIR /app
ADD target/gestion-station-ski-1.0.jar /app/gestion-station-ski-1.0.jar
ENTRYPOINT ["java","-jar","/gestion-station-ski-1.0.jar"]