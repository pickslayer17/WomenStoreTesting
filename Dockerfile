FROM openjdk:17
EXPOSE 8080
ADD target/WomenStoreTesting.jar WomenStoreTesting.jar
ENTRYPOINT ["java", "-jar", "/WomenStoreTesting.jar"]