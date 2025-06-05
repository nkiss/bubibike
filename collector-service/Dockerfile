# Use a minimal image for the final app
FROM eclipse-temurin:21-jre

# Set working directory in final image
WORKDIR /app

# Copy the fat jar from the build image
COPY build/libs/*.jar app.jar

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
