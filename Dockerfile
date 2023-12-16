 FROM maven:3.8.5-openjdk-17 As bluid
 COPY . .
 RUN mvn clean package -DskipTests
 FROM openjdk:17.0.1-jdk-slim
 COPY --from=bluid /target/learnspring-0.0.1-SNAPSHOT.jar learnspring.jar
 EXPOSE 8080
 ENTRYPOINT ["java","-jar","learnspring.jar"]