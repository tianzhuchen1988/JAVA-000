### 一、（必做）作业题目：设计对前面的订单表数据进行水平分库分表，拆分 2 个库，每个库 16 张表。并在新结构在演示常见的增删改查操作。代码、sql 和配置文件，上传到 Github。
- 基于shardingsphere-proxy作为中间件进行分库分表以后的增删改查
- 将原先order.t_order表分成order0及order1两个库的t_order_0~15
- sharding配置文件如下:
```
schemaName: sharding_db
dataSourceCommon:
  username: root
  password:
  connectionTimeoutMilliseconds: 30000
  idleTimeoutMilliseconds: 60000
  maxLifetimeMilliseconds: 1800000
  maxPoolSize: 50
  minPoolSize: 1
  maintenanceIntervalMilliseconds: 30000
dataSources:
  ds_0:
    url: jdbc:mysql://127.0.0.1:3306/order0?serverTimezone=UTC&useSSL=false
  ds_1:
    url: jdbc:mysql://127.0.0.1:3306/order1?serverTimezone=UTC&useSSL=false
rules:
- !SHARDING
  tables:
    t_order:
      actualDataNodes: ds_${0..1}.t_order_${0..15}
      tableStrategy:
        standard:
          shardingColumn: order_id
          shardingAlgorithmName: t_order_inline
      keyGenerateStrategy:
        column: order_id
        keyGeneratorName: snowflake
  bindingTables:
    - t_order
  defaultDatabaseStrategy:
    standard:
      shardingColumn: user_id
      shardingAlgorithmName: database_inline
  defaultTableStrategy:
    none:
  
  shardingAlgorithms:
    database_inline:
      type: INLINE
      props:
        algorithm-expression: ds_${user_id % 2}
    t_order_inline:
      type: INLINE
      props:
        algorithm-expression: t_order_${order_id % 16}
  
  keyGenerators:
    snowflake:
      type: SNOWFLAKE
      props:
        worker-id: 123
```
- sharding-demo工程的datasource信息直接使用shardingsphere-proxy的sharding_db进行t_order的查询
