FROM maven:3.8.6-openjdk-11 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn package -DskipTests

FROM tomcat:9.0-jdk11
COPY --from=build /app/target/gestion_g2_spring_mvc.war /usr/local/tomcat/webapps/

EXPOSE 8080