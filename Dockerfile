FROM openjdk:21
WORKDIR /app

COPY target/jdbc_spring_bookshop-0.0.1-SNAPSHOT.jar /app/app.jar

EXPOSE 8080
EXPOSE 5432

CMD ["java", "-jar", "app.jar"]
