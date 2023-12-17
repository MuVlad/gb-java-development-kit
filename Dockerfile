FROM openjdk:17-alpine
COPY out/artifacts/hw4_jar/gb-java-development-kit.jar /tmp/app.jar
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "app.jar"]