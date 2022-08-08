FROM adoptopenjdk/openjdk11:jdk-11.0.11_9
LABEL maintainer="osvald.soza@gmail.com"
ARG JAR_FILE=target/builders-api-0.0.1-SNAPSHOT.jar
WORKDIR /opt/app
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","app.jar","--spring.datasource.url=jdbc:postgresql://postgres-builders-api/builder?createDatabaseIfNotExist=true&serverTimezone=UTC"]