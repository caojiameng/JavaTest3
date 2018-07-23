FROM registry.cn-hangzhou.aliyuncs.com/choerodon-tools/mysql:5.7.17
ADD . /docker
WORKDIR /docker
RUN mysql -uroot -proot -e "create database sakila;use sakila;source sakila-schema.sql;source sakila-data.sql;grant all privileges on *.* to 'root'@'%';flush privileges;"
