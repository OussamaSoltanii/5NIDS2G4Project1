FROM openjdk:8-jdk
EXPOSE 8089
ADD target/gestion-station-ski-1.0.jar 5nids2g4project1.jar/
ENTRYPOINT ["java","-jar","/5nids2g4project1.jar"]
