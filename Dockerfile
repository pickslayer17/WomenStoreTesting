FROM openjdk:8
EXPOSE 8080
ADD target/WomenStoreTesting.jar WomenStoreTesting.jar
ENTRYPOINT ["java", "-jar", "/WomenStoreTesting.jar"]