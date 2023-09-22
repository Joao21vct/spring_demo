# Build stage
FROM maven:3.8-openjdk-18 AS maquinabuild
COPY . .
RUN mvn clean package -DskipTests

# Package stage / deploy
FROM openjdk:17-jdk-slim
COPY --from=maquinabuild /target/produtoAPI-0.0.1-SNAPSHOT.jar fidalgo.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "fidalgo.jar"]
