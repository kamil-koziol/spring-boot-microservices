FROM eclipse-temurin:17.0.6_10-jre as runtime

ENV VERSION="1.0.0-SNAPSHOT"

ENV SERVER_PORT=8080

EXPOSE 8080

COPY target/exercises-${VERSION}.jar /opt/exercises/exercises.jar

CMD ["java", "-jar", "/opt/exercises/exercises.jar"]
