FROM adoptopenjdk/openjdk11:latest
EXPOSE 8080
ARG JAR_FILE=target/api-rest-app-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} api-rest-app.jar
ENTRYPOINT ["java","-jar","/api-rest-app.jar"]