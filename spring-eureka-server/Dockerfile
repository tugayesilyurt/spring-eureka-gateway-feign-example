FROM maven:3.6.3 AS maven
LABEL MAINTAINER="htyesilyurt@gmail.com"

WORKDIR /opt/discovery
COPY . /opt/discovery
RUN mvn clean install 

# For Java 11, 
FROM adoptopenjdk/openjdk11:alpine-jre

ARG JAR_FILE=discovery.jar

WORKDIR /opt/discovery

COPY --from=maven /opt/discovery/target/${JAR_FILE} /opt/discovery/

ENTRYPOINT ["java","-jar","discovery.jar"]