#!/usr/bin/env bash
# 打包，生成镜像

mvn clean install

docker build . -f ./docker/mysql/Dockerfile -t zmf/mysql:1.0-my
docker build . -f ./docker/java/Dockerfile -t zmf/java:1.0-my