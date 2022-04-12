FROM maven
WORKDIR /workspace/app
COPY mvnw .
COPY pom.xml .
COPY src src
RUN mvn package
EXPOSE 8080
WORKDIR /workspace/app/target
RUN mv *.war app.war
CMD ["java","-jar","app.war"]

