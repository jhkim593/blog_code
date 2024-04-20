FROM openjdk:17-jdk-slim

#jar
ARG JAR_FILE=build/libs/scaledJob.jar
COPY ${JAR_FILE} scaledJob.jar

#curl
RUN apt-get update && apt-get install -y \
curl

#entrypoint
COPY entrypoint.sh /entrypoint.sh
RUN ["chmod", "+x", "/entrypoint.sh"]

ENTRYPOINT ["/entrypoint.sh"]