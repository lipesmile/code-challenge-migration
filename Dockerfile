FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/dummyjson-client-1.0-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar", "-Dspring.profiles.active=${ENV}","app.jar"]