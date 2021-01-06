### redis 的主从复制
- 本机模拟主从，master的端口为6379，slave的端口为6380
- slave的redis.conf中添加master的配置信息 replicaof 127.0.0.1 6379
- master节点设置key "kk" -> "vv", slave节点能正常获取
![image](https://github.com/tianzhuchen1988/JAVA-000/blob/main/Week_12/images/1609902017(1).jpg)
![image](https://github.com/tianzhuchen1988/JAVA-000/blob/main/Week_12/images/1609902061(1).jpg)
