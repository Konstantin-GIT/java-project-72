FROM eclipse-temurin:20-jdk

WORKDIR /app

COPY gradle gradle
COPY gradlew .
COPY / .

COPY src src
COPY config config

RUN ./gradlew installDist

EXPOSE 7070


CMD ./build/install/app/bin/app