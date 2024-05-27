# Use a base image with Java and Maven installed
FROM maven:3.8.4-openjdk-11 AS build

# Set the working directory in the container
WORKDIR /app

# Copy the pom.xml file to download dependencies
COPY pom.xml .

# Copy the rest of the application source code
COPY src ./src

# Build the application
RUN mvn clean package -DskipTests

# Create the final container
FROM openjdk:11-jre-slim

# Set the working directory
WORKDIR /app

# Copy the JAR file from the build stage to the final container
COPY --from=build /app/target/calendar-calculator.jar .

# Expose the port your application runs on
EXPOSE 8080

# Command to run the application
CMD ["java", "-jar", "calendar-calculator.jar"]
