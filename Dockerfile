FROM gradle:8-jdk21 AS build
WORKDIR /test
COPY . .
RUN chmod +x ./gradlew
RUN ./gradlew clean :app:bootJar --no-daemon

FROM eclipse-temurin:21-jre
WORKDIR /test
COPY --from=build /test/app/build/libs/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
