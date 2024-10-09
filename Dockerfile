#This Dockerfile builds and runs the Java application.
#It copies the JAR file and runs it using the Java runtime (openjdk image)

# Official OpenJDK Docker image
FROM openjdk:latest

# Copy the built JAR file from the target directory
COPY ./target/population-reporting-system-0.1.0.1-jar-with-dependencies.jar /tmp

# Set /tmp as the working directory where commands will be executed
WORKDIR /tmp

# Run the JAR file when the container starts
ENTRYPOINT ["java", "-jar", "population-reporting-system-0.1.0.1-jar-with-dependencies.jar"]