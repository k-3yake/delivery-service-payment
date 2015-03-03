FROM ubuntu:14.04
MAINTAINER Katsuki Miyake <3katsu3hiro@gmail.com>

RUN apt-get update

#Install Utility
RUN apt-get update && apt-get install -y software-properties-common python-software-properties

#Install Java8
RUN add-apt-repository ppa:webupd8team/java -y
RUN apt-get update
RUN echo oracle-java8-installer shared/accepted-oracle-license-v1-1 select true | /usr/bin/debconf-set-selections
RUN apt-get install -y oracle-java8-installer

#Start Play app
EXPOSE 9000
ADD target/universal/delivery-service-payment-1.0.tgz /home/
CMD cd /home/delivery-service-payment-1.0/bin && bash delivery-service-payment







