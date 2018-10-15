FROM anapsix/alpine-java:8
RUN apk add --no-cache curl
COPY ./build/libs/*SNAPSHOT.jar app.jar
COPY ./entrypoint.sh /entrypoint.sh
ENV JAVA_OPTS=""
ENV PROFILE="dev"
EXPOSE 8088
ENTRYPOINT ["sh", "entrypoint.sh"]