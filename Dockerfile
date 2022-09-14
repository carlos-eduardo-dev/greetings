FROM adoptopenjdk/openjdk11

WORKDIR /app

COPY build/libs/greetings-*-all.jar /app/application.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/application.jar"]
