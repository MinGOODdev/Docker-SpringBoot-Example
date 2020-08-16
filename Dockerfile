#FROM openjdk:8 AS builder
#ADD target/docker-0.0.1-SNAPSHOT.jar app.jar
#ENV JAVA_OPTS=""
#ENTRYPOINT ["java", "-jar", "/app.jar"]

FROM maven:3.5.2-jdk-8-alpine AS maven_builder
LABEL maintainer=Groot

# 이미지에 build 디렉토리 생성 후 pom.xml 복사
COPY pom.xml /build/
COPY src /build/src
# 디렉토리 변경
WORKDIR /build/
RUN mvn package

# 이 시점에 maven:3.5.2-jdk-8-alpine 이미지는 폐기된다.
FROM openjdk:8-jre-alpine
WORKDIR /app
COPY --from=maven_builder /build/target/docker-0.0.1-SNAPSHOT.jar /app/

ARG ENVIRONMENT
ENV SPRING_PROFILES_ACTIVE=${ENVIRONMENT}

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "docker-0.0.1-SNAPSHOT.jar"]