FROM openjdk:17-jdk-alpine3.14
COPY "./target/recept-weblap.jar" "/app/recept-weblap.jar"
EXPOSE 8080
CMD [ "java", "-jar", "/app/recept-weblap.jar" ]