FROM maven:3.6.3 AS maven
LABEL MAINTAINER="htyesilyurt@gmail.com"

WORKDIR /opt/gateway
COPY . /opt/gateway
RUN mvn clean install 

# For Java 11, 
FROM adoptopenjdk/openjdk11:alpine-jre

ARG JAR_FILE=gateway-service.jar

WORKDIR /opt/gateway

COPY --from=maven /opt/gateway/target/${JAR_FILE} /opt/gateway/

ENTRYPOINT ["java","-jar","gateway-service.jar"]