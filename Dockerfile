FROM openjdk:11-jdk
EXPOSE 8089
ADD 5NIDS2-G4-Projet1GestSki-1.0.jar KhadijaAgoun-5NIDS2-G4-Projet1-1.0.jar
ENTRYPOINT ["java","-jar","/KhadijaAgoun-5NIDS2-G4-Projet1-1.0.jar"]