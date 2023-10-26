FROM openjdk:8-jdk
EXPOSE 8089
ADD target/Projet1_Devops-1.jar Projet1_Devops-1.jar
ENTRYPOINT ["java","-jar","/Projet1_Devops-1.jar"]
