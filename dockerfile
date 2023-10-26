FROM openjdk:11-jdk

EXPOSE 8089

ADD Project1.jar Project1.jar

ENTRYPOINT ["java", "-jar", "/Project1.jar"]