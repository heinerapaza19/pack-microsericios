# =========================
# BUILD STAGE (DEV/PROD BUILD)
# =========================
FROM maven:3.9.9-eclipse-temurin-21 AS build

WORKDIR /app

# copiar pom primero (cache dependencias)
COPY pom.xml .

RUN mvn -q -DskipTests dependency:go-offline

# copiar código fuente
COPY src ./src

# compilar proyecto
RUN mvn -q clean package -DskipTests


# =========================
# RUNTIME STAGE (PRODUCCIÓN)
# =========================
FROM eclipse-temurin:21-jre

WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

# PUERTO DE TU MICROSERVICIO
EXPOSE 9999

# ejecutar app
ENTRYPOINT ["java", "-jar", "app.jar"]