FROM molgenis/maven-jdk17
WORKDIR /spring-eureka-server
COPY . .
RUN mvn clean install
CMD mvn spring-boot:run