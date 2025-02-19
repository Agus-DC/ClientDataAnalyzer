FROM gradle:7.4.0-jdk17 AS builder
WORKDIR /builder
COPY . ./
RUN gradle clean build

FROM openjdk:17-jdk-slim AS runner
RUN ls
COPY --from=builder /builder/build/libs/*.jar /home/app.jar
WORKDIR /home
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]