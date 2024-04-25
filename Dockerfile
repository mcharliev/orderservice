# D:\javaProjects\microservices\orderservice\Dockerfile
FROM openjdk:17
COPY ./target/orderservice-0.0.1-SNAPSHOT.jar /app/orderservice.jar
CMD ["java", "-jar", "/app/orderservice.jar"]