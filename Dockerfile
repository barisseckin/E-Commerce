FROM adoptopenjdk/openjdk15
EXPOSE 8080
ARG JAR_FILE=target/eCommerceProject-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} ecommercev1.jar
ENTRYPOINT ["java", "-jar", "/ecommercev1.jar"]
