### 1、redis 的主从复制
- 配置文件路径：https://github.com/tianzhuchen1988/JAVA-000/tree/main/Week_12/master-slave
- 本机模拟主从，master的端口为6379，slave的端口为6380
- slave的redis.conf中添加master的配置信息 replicaof 127.0.0.1 6379
- master节点设置key "kk" -> "vv", slave节点能正常获取
![image](https://github.com/tianzhuchen1988/JAVA-000/blob/main/Week_12/images/1609902017(1).jpg)
![image](https://github.com/tianzhuchen1988/JAVA-000/blob/main/Week_12/images/1609902061(1).jpg)

### 2、配置sentinel 高可用
- 配置文件路径：https://github.com/tianzhuchen1988/JAVA-000/tree/main/Week_12/sentinel
- sentinel只配置了一个节点，配置文件中，只要有1个sentinel觉得master挂了，就做主从的切换
![image](https://github.com/tianzhuchen1988/JAVA-000/blob/main/Week_12/images/1609903509(1).jpg)

### 3、配置Cluster 集群
