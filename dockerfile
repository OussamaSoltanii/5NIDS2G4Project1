FROM openjdk:11-jdk

EXPOSE 8089

ADD 5nids2g4project1 5nids2g4project1

ENTRYPOINT ["java", "-jar", "/5nids2g4project1"]