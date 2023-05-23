FROM openjdk:17-jdk-alpine3.14

COPY "./target/recipe.jar" "/application/recipe.jar"

CMD ["java", "-jar", "/application/recipe.jar"]