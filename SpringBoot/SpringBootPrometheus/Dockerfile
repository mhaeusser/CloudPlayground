FROM openjdk:11-jdk as base

COPY target/SpringBootPrometheus-1.0-SNAPSHOT.jar /opt

WORKDIR /opt

EXPOSE 8080

# Runs when the container launches
CMD ["java", "-jar", "SpringBootPrometheus-1.0-SNAPSHOT.jar"]
