FROM openjdk:17-jdk-slim

ARG JAR_FILE=build/libs/scaledJob-1.jar

COPY ${JAR_FILE} scaledJob-1.jar

ENTRYPOINT ["java","-jar","/scaledJob-1.jar"]