FROM amazoncorretto:17-alpine-jdk
LABEL maintainer="Kaouther Ben Sassi bensassi.kaouther@gmail.com"
COPY target/transactionsService-0.0.1-SNAPSHOT.jar transactionsService-0.0.1-SNAPSHOT.jar
CMD ["java", "-jar", "transactionsService-0.0.1-SNAPSHOT.jar"]