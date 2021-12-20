FROM maven:3.6.3 AS maven
LABEL MAINTAINER="htyesilyurt@gmail.com"

WORKDIR /opt/customer-service
COPY . /opt/customer-service
RUN mvn clean install 

# For Java 11, 
FROM adoptopenjdk/openjdk11:alpine-jre

ARG JAR_FILE=customer-service.jar

WORKDIR /opt/customer-service

COPY --from=maven /opt/customer-service/target/${JAR_FILE} /opt/customer-service/

ENTRYPOINT ["java","-jar","customer-service.jar"]