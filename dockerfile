FROM openjdk:11-jdk
EXPOSE 8089
ADD 5NIDS-G4-P1Gestion-station-ski-1.0.jar SoltaniOussama-5NIDS2-G4-gestion-station-ski-1.0.jar
ENTRYPOINT ["java","-jar","/SoltaniOussama-5NIDS2-G4-gestion-station-ski-1.0.jar"]
