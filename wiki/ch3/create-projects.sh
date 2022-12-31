#!/bin/sh

mkdir src/microservices
cd src/microservices

spring init \
--boot-version=2.7.0.RELEASE \
--type=gradle-project \
--build=gradle \
--java-version=17 \
--packaging=jar \
--name=product-service \
--package-name=think.roon.handsonmicroservices.ch3.microservices.core.product \
--groupId=think.roon \
--dependencies=actuator,webflux \
--version=1.0.0-SNAPSHOT \
product-service

spring init \
--boot-version=2.7.0.RELEASE \
--type=gradle-project \
--build=gradle \
--java-version=17 \
--packaging=jar \
--name=review-service \
--package-name=think.roon.handsonmicroservices.ch3.microservices.core.product \
--groupId=think.roon \
--dependencies=actuator,webflux \
--version=1.0.0-SNAPSHOT \
review-service

spring init \
--boot-version=2.7.0.RELEASE \
--type=gradle-project \
--build=gradle \
--java-version=17 \
--packaging=jar \
--name=recommendation-service \
--package-name=think.roon.handsonmicroservices.ch3.microservices.core.product \
--groupId=think.roon \
--dependencies=actuator,webflux \
--version=1.0.0-SNAPSHOT \
recommendation-service

spring init \
--boot-version=2.7.0.RELEASE \
--type=gradle-project \
--build=gradle \
--java-version=17 \
--packaging=jar \
--name=product-composite-service \
--package-name=think.roon.handsonmicroservices.ch3.microservices.core.product \
--groupId=think.roon \
--dependencies=actuator,webflux \
--version=1.0.0-SNAPSHOT \
product-composite-service

# cd ..