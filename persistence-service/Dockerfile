FROM eclipse-temurin:21-jre

# Create a group and user with no root privileges
RUN addgroup --system appgroup && adduser --system --ingroup appgroup appuser

WORKDIR /app

COPY build/libs/*.jar app.jar

# Change ownership of the app directory
RUN chown -R appuser:appgroup /app

# Switch to the non-root user
USER appuser

ENTRYPOINT ["java", "-jar", "app.jar"]