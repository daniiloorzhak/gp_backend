FROM openjdk:17
MAINTAINER daniil
COPY target/gp-0.0.1-SNAPSHOT.jar gp-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "gp-0.0.1-SNAPSHOT.jar"]
