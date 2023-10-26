FROM openjdk:8-jdk
EXPOSE 8089
ADD D:/Users/SRN/Desktop/Projet 1_Devops/5nids2g4project1.jar 5nids2g4project1.jar/
ENTRYPOINT ["java","-jar","/5nids2g4project1.jar"]
