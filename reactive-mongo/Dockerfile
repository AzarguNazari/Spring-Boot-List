FROM openjdk:8-jdk-alpine

ADD target/reactive-mongo-1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java","-jar","/app.jar"]