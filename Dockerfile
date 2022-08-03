FROM openjdk:8-jdk-alpine
LABEL maintainer="cis"
ADD /target/*.jar app.jar
EXPOSE 8082
ENTRYPOINT ["java", "-jar","/app.jar"]