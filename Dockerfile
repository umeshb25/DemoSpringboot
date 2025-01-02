
# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim as builder

# Set the working directory inside the container
WORKDIR /app

# Copy the pom.xml and mvnw files into the container
COPY pom.xml mvnw ./
COPY .mvn .mvn

# Download dependencies to avoid re-downloading them on every build
RUN ./mvnw dependency:go-offline

# Copy the rest of your application source code
COPY src ./src

# Package the application (creates a fat jar)
RUN ./mvnw clean package -DskipTests

# Use a smaller JDK runtime image for running the application
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the packaged jar file from the builder stage to the final image
COPY --from=builder /app/target/demo-0.0.1-SNAPSHOT.jar /app/demo.jar

# Expose the port the app will run on (default Spring Boot port is 8080)
EXPOSE 8090

# Run the application
ENTRYPOINT ["java", "-jar", "demo.jar"]

