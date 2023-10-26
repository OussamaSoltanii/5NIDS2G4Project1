FROM openjdk:11-jdk

EXPOSE 8089

ADD target/5NIDS2G4Project1.jar 5NIDS2G4Project1.jar

ENTRYPOINT ["java", "-jar", "/5NIDS2G4Project1.jar"]