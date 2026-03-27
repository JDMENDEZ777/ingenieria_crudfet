# 1. Imagen base
FROM eclipse-temurin:21-jdk-jammy

# 2. Directorio de trabajo
WORKDIR /app

# 3. Copiar el ejecutable
COPY target/*.jar app.jar

# 4. Comando de inicio (Sin comillas sueltas ni caracteres extra)
ENTRYPOINT ["java", "-jar", "app.jar"]