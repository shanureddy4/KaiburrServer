FROM maven
WORKDIR /workspace/app
COPY mvnw .
COPY pom.xml .
COPY src src
RUN mvn spring-boot:run
EXPOSE 8080
WORKDIR /workspace/app/target
RUN mv *.war app.war
CMD ["java","-jar","app.war"]

