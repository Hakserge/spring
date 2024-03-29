 FROM maven:3.8.5-openjdk-17 As bluid
 WORKDIR /app
 COPY . /app
 RUN mvn clean package -DskipTests
 FROM openjdk:17.0.1-jdk-slim
 WORKDIR /app
 COPY --from=bluid app/target/learnspring-0.0.1-SNAPSHOT.jar /app/app.jar
 EXPOSE 8080
CMD ["java", "-jar","app.jar"]
