FROM maven:3.8-jdk-11 AS MAVEN_TOOL_CHAIN
COPY pom.xml /tmp/
COPY src /tmp/src/
WORKDIR /tmp/
RUN mvn package -Dmaven.test.skip=true

FROM  adoptopenjdk/openjdk11
COPY --from=MAVEN_TOOL_CHAIN /tmp/target/*.jar app.jar
ENTRYPOINT ["java","-Xmx512m","-Dserver.port=${PORT}","-Djwt.secret=${SECRET}","-jar","/app.jar"]