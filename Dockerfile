FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 8080
COPY /build/libs/lukuvinkki-applikaatio.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]

