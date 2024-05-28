#
# Build stage
#
FROM gradle:jdk21-jammy AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build --no-daemon

LABEL org.name="Martin"
#
# Package stage
#
FROM eclipse-temurin:21-jdk-jammy
COPY --from=build /home/gradle/src/build/libs/webtech-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]