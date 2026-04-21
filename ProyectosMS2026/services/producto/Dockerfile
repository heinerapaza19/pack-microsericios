<<<<<<< HEAD
FROM maven:3.9.9-eclipse-temurin-17 AS build
=======
FROM maven:3.9.9-eclipse-temurin-21 AS build
>>>>>>> e30ec6ca0401742abeeeb038f1524e086cd71b1b
WORKDIR /app

COPY pom.xml .
RUN mvn -q -DskipTests dependency:go-offline

COPY src ./src
RUN mvn -q clean package -DskipTests

<<<<<<< HEAD
FROM eclipse-temurin:17-jre
=======
FROM eclipse-temurin:21-jre
>>>>>>> e30ec6ca0401742abeeeb038f1524e086cd71b1b
WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

EXPOSE 9092

ENTRYPOINT ["java", "-jar", "app.jar"]

