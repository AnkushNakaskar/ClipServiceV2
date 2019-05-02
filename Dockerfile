FROM openjdk:8-jre-alpine

RUN mkdir -p /opt/cms/logs
RUN pwd
RUN ls
#COPY  google-spring.jar /opt/cms/
ADD build/libs/google-spring.jar /opt/cms/google-spring.jar
WORKDIR /opt/cms/
RUN ls
VOLUME /opt/cms/
VOLUME /opt/
VOLUME /opt/cms/logs


ENV HOME /opt/cms/
RUN chmod -R 777 /opt/cms/
RUN chmod -R 777 /opt/cms/logs
ENTRYPOINT ["java","-jar","google-spring.jar"]
