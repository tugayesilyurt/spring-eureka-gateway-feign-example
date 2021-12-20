FROM maven:3.6.3 AS maven
LABEL MAINTAINER="htyesilyurt@gmail.com"

WORKDIR /opt/product-service
COPY . /opt/product-service
RUN mvn clean install 

# For Java 11, 
FROM adoptopenjdk/openjdk11:alpine-jre

ARG JAR_FILE=product-service.jar

WORKDIR /opt/product-service

COPY --from=maven /opt/product-service/target/${JAR_FILE} /opt/product-service/

ENTRYPOINT ["java","-jar","product-service.jar"]