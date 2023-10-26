FROM openjdk:8-jdk
EXPOSE 8089
ADD D:/Users/SRN/Desktop/Projet 1_Devops/5NIDS2G4Project1/target/gestion-station-ski-1.0.jar 5nids2g4project1.jar/
ENTRYPOINT ["java","-jar","/5nids2g4project1.jar"]
