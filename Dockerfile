#FROM openjdk:8 AS builder
#ADD target/docker-0.0.1-SNAPSHOT.jar app.jar
#ENV JAVA_OPTS=""
#ENTRYPOINT ["java", "-jar", "/app.jar"]

FROM maven:3.5.2-jdk-8-alpine AS maven_builder

LABEL maintainer=Minkuk

COPY pom.xml /build/
COPY src /build/src
WORKDIR /build/
RUN mvn package

FROM openjdk:8-jre-alpine
WORKDIR /app
COPY --from=maven_builder /build/target/docker-0.0.1-SNAPSHOT.jar /app/

ENTRYPOINT ["java", "-jar", "docker-0.0.1-SNAPSHOT.jar"]