from maven:3-jdk-8
COPY . /usr/src/app
WORKDIR /usr/src/app
RUN mvn -Dmaven.test.skip=true package spring-boot:repackage


