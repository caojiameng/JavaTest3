### docker-compose方式启动
  去docker-compose.yml所在目录执行`docker-compose up`
  
### docker run方式启动
  ```
  docker pull registry.cn-hangzhou.aliyuncs.com/choerodon-tools/mysql:5.7.17
  docker run -p 3306:3306 --name mysql -e MYSQL_ROOT_PASSWORD=123456 -d registry.cn-hangzhou.aliyuncs.com/choerodon-tools/mysql:5.7.17
  ```
  
### 启动完成
  `docker ps`查看是否有mysql容器
  
### mysql倒入sql
  1. 使用mysql GUI工具连接mysql，倒入sql
  2. 使用命令行倒入
  ```
  docker cp sql文件路径 ID全称:容器路径
  docker exec -it 容器ID mysql -uroot -proot 进入mysql
  source sql路径导入
  ```
  