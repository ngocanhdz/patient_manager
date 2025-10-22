# ================================
# 1. Build stage (compile app)
# ================================
FROM maven:3.9.9-eclipse-temurin-21 AS builder
WORKDIR /app

# Copy pom.xml và cài dependency trước để tận dụng cache
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copy toàn bộ source và build
COPY src ./src
RUN mvn clean package -DskipTests

# ================================
# 2. Run stage (runtime)
# ================================
FROM openjdk:21-jdk AS runner
WORKDIR /app

# Copy file JAR từ stage build
COPY --from=builder ./app/target/api-gateway-0.0.1-SNAPSHOT.jar ./app.jar

# Expose port (nếu app chạy ở 4000)
EXPOSE 4004

# Command chạy ứng dụng
ENTRYPOINT ["java", "-jar", "app.jar"]
