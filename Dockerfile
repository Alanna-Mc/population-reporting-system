# This Dockerfile sets up and runs the Java application using a JAR file.

# Official OpenJDK Docker image
FROM openjdk:latest

# Copy the compiled JAR file from the target directory to /tmp in the container
COPY ./target/population-reporting-system-0.1.0.3-jar-with-dependencies.jar /tmp

# Set /tmp as the working directory
WORKDIR /tmp

# Run the JAR file when the container starts
ENTRYPOINT ["java", "-jar", "population-reporting-system-0.1.0.3-jar-with-dependencies.jar"]