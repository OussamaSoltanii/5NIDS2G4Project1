FROM openjdk:8-jdk-alpine
EXPOSE 8089
ADD target/projet1-1.0.jar projet1-1.0.jar
ENTRYPOINT ["java","-jar","/projet1-1.0.jar"]
