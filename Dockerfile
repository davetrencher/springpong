FROM openjdk:8-jdk-alpine

RUN addgroup -S appuser && adduser -S -G appuser appuser
USER appuser

VOLUME /tmp

WORKDIR /app
ADD build/libs/springpong-0.0.2-SNAPSHOT.jar springpong.jar
ENV JAVA_OPTS=""
EXPOSE 8080
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app/springpong.jar" ]