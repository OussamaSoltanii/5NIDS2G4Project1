FROM openjdk:8-jdk
EXPOSE 8089
ADD target/projet1_devops-1.jar projet1_devops-1.jar
ENTRYPOINT ["java","-jar","/projet1_devops-1.jar"]
