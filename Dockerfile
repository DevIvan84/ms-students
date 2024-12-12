ARG MS_NAME=student_service

FROM openjdk:21 AS build-image-stage

ARG MS_NAME

WORKDIR /app/$MS_NAME

COPY ./.mvn ./.mvn
COPY ./mvnw .
COPY ./pom.xml .

RUN ./mvnw clean package -Dmaven.test.skip -Dmaven.main.skip -Dspring.boot.repackage.skip && rm -r ./target

COPY ./src ./src

RUN ./mvnw clean package -DskipTests

FROM openjdk:21

ARG MS_NAME

WORKDIR /app

COPY --from=build-image-stage /app/$MS_NAME/target/student-service-0.0.1-SNAPSHOT.jar .

EXPOSE 8080

CMD ["java", "-jar", "student-service-0.0.1-SNAPSHOT.jar"]