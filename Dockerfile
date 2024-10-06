FROM openjdk:latest

# Copy the correct JAR file
COPY ./target/population-reporting-system-0.1.0.1-jar-with-dependencies.jar /tmp

# Set the working directory
WORKDIR /tmp

# Run the JAR file
ENTRYPOINT ["java", "-jar", "population-reporting-system-0.1.0.1-jar-with-dependencies.jar"]