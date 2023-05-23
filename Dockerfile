FROM openjdk:17-jdk-alpine3.14

COPY "./target/recept-weblap.jar" "/application/recept-weblap.jar"

CMD ["java", "-jar", "/application/recept-weblap.jar"]