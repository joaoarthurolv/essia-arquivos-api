FROM openjdk:17
EXPOSE 8080
COPY essia-arquivos-api-rest-producer/target/essia-arquivos-api-rest-producer.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]