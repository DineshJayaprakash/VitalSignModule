FROM adoptopenjdk/openjdk11
EXPOSE 8083
ADD /target/VitalSignModule-0.0.1-SNAPSHOT.jar VitalSignModule.jar
ENTRYPOINT ["java","-jar","/VitalSignModule.jar"]