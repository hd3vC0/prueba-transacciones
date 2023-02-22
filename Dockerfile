FROM openjdk:17
VOLUME /tmp
EXPOSE 8080
ENV DB_USER=root
ENV DB_PASSWORD=changeit
ENV MYSQL_HOST=localhost
ADD build/libs/*.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]