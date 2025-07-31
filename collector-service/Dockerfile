# Use a minimal image for the final app
FROM eclipse-temurin:21-jre

# Create a group and user with no root privileges
RUN addgroup --system appgroup && adduser --system --ingroup appgroup appuser

# Set working directory in final image
WORKDIR /app

# Copy the fat jar from the build image
COPY build/libs/*.jar app.jar

# Change ownership of the app directory
RUN chown -R appuser:appgroup /app

# Switch to the non-root user
USER appuser

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
