
mvn clean install

docker build . -f ./docker/mysql/Dockerfile -t registry.cn-hangzhou.aliyuncs.com/choerodon-tools/mysql:5.7.17
docker build . -f ./docker/java/Dockerfile -t registry.saas.hand-china.com/hap-cloud/base:latest