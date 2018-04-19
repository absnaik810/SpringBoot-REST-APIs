FROM openjdk:8
ADD target/SpringBootRESTAPI-6.0-SNAPSHOT.jar SpringBootRESTAPI-6.0-SNAPSHOT.jar
EXPOSE 8086
ENTRYPOINT ["java", "-jar", "SpringBootRESTAPI-6.0-SNAPSHOT.jar"]