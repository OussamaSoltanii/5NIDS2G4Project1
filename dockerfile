FROM openjdk:11-jdk

EXPOSE 8089

ADD Project1 Project1

ENTRYPOINT ["java", "-jar", "/Project1"]