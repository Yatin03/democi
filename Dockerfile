FROM openjdk:17-jdk
EXPOSE 8080
COPY target/adder-0.0.1-SNAPSHOT.war /app.war
CMD ["java", "-jar", "/app.war"]
