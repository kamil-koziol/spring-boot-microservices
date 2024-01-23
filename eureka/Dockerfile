FROM eclipse-temurin:17.0.6_10-jre

ENV VERSION="1.0.0-SNAPSHOT"

ENV SERVER_PORT=8080

EXPOSE 8080

COPY target/eureka-${VERSION}.jar /opt/eureka/eureka.jar

CMD ["java", "-jar", "/opt/eureka/eureka.jar"]
