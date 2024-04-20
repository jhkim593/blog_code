FROM openjdk:17-jdk-slim

ARG JAR_FILE=build/libs/scaledJob.jar

COPY ${JAR_FILE} scaledJob.jar

ENTRYPOINT ["java","-jar","/scaledJob.jar","&"]