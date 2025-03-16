# Use an official JDK runtime as a base image
FROM openjdk:21-jdk

# Set the working directory inside the container
WORKDIR /app

# Copy the built JAR file into the container
COPY target/dashboard-0.0.1-SNAPSHOT.jar app.jar

COPY src/main/resources/IPL_Matches_2008_2022.csv /app/resources/
# Expose the application port
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
