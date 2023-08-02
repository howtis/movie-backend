FROM amazoncorretto:17-alpine-jdk

ENV GRADLE_VERSION=8.1.1
RUN wget -q "https://services.gradle.org/distributions/gradle-${GRADLE_VERSION}-bin.zip" \
    && unzip -q "gradle-${GRADLE_VERSION}-bin.zip" -d /opt \
    && rm "gradle-${GRADLE_VERSION}-bin.zip"

ENV GRADLE_HOME=/opt/gradle-${GRADLE_VERSION}
ENV PATH=${GRADLE_HOME}/bin:${PATH}

WORKDIR /app
COPY . /app

RUN gradle build --exclude-task test

CMD ["sh", "-c", "java -jar $(find /app/build/libs -maxdepth 1 -type f -name '*.jar' ! -name '*-plain.jar')"]