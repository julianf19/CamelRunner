FROM eclipse-temurin:21-jdk


RUN mkdir /camelbin
WORKDIR /camelbin

RUN mkdir ./ImportXLS
RUN mkdir ./ImportXLSAndDelete


COPY ./pom.xml .
COPY ./start_docker.sh ./start.sh
COPY ./conf ./conf
COPY ./target/camelrunner.jar ./target/camelrunner.jar

EXPOSE 8778

ENTRYPOINT ./start.sh

