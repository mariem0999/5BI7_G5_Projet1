FROM openjdk:11

COPY target/gestion-station-ski-1.0.jar /app/app.jar

EXPOSE 8089

CMD ["java", "-jar", "/app/app.jar"]