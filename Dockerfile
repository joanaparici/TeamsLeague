FROM openjdk:17-jdk-alpine
RUN mkdir /opt/app
COPY ./boot/target/boot-0.0.1-SNAPSHOT.jar /opt/app/japp.jar
CMD ["java", "-jar", "/opt/app/japp.jar"]
