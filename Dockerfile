FROM adoptopenjdk/openjdk8:alpine-slim
COPY target/search-0.0.1-SNAPSHOT.jar /search-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/search-0.0.1-SNAPSHOT.jar"]