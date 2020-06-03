FROM openjdk:8-jdk-alpine

WORKDIR /build

RUN wget -qO- https://repo1.maven.org/maven2/org/flywaydb/flyway-commandline/6.4.3/flyway-commandline-6.4.3-linux-x64.tar.gz | tar xvz && ln -s `pwd`/flyway-6.4.3/flyway /usr/local/bin

WORKDIR /deploy

COPY . /deploy

RUN ./mvnw -Dmaven.test.skip=true package

RUN apk update && apk add bash

ENTRYPOINT ["sh", "entrypoint.sh"]

