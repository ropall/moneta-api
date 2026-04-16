# Etapa 1: compilar
FROM maven:3.9.6-eclipse-temurin-21 AS builder
WORKDIR /app

# 1. Copiamos SOLO el pom.xml primero
COPY pom.xml .

# 2. Descargamos dependencias (Esto se guarda en caché)
RUN mvn dependency:go-offline

# 3. AHORA copiamos el código y compilamos
COPY src ./src
RUN mvn clean package -DskipTests

# Etapa 2: imagen final liviana
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]