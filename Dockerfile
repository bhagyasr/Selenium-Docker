FROM openjdk:8u191-jre-alpine

#Install curl and jq is seperator for json

RUN apk add curl jq

WORKDIR /bhagya/test

#ADD ALL Dependancies

ADD target/selenium-docker.jar selenium-docker.jar
ADD target/selenium-docker-tests.jar selenium-docker-tests.jar
ADD target/libs libs
ADD bookFlightModule.xml bookFlightModule.xml
ADD searchmodule.xml searchmodule.xml
ADD src/test/java/ss.png ss.png

#ADD healthcheck script
ADD healthcheck.sh healthcheck.sh

#ENTRY POINT

ENTRYPOINT sh healthcheck.sh

