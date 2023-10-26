FROM amazoncorretto:17-alpine-jdk

WORKDIR /app

COPY build/libs/movie-0.0.1-SNAPSHOT.jar /app/app.jar

CMD ["java", "-jar", "app.jar"]
