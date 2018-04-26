FROM openjdk:8

ADD /docker-1.0.0-SNAPSHOT.jar myapp.jar
RUN sh -c 'touch /myapp.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/urandom","-jar","myapp.jar"]