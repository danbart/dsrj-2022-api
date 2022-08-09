#!/bin/sh

docker stop dsrj-api

docker rm dsrj-api

docker rmi dsrj-api_2022
#
mvn clean package
docker-compose up

read