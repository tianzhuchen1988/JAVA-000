### 学习笔记
#### 作业题目：写代码实现 Spring Bean 的装配，方式越多越好（XML、Annotation 都可以）, 提交到 Github。
- 采用xml方式: 
https://github.com/tianzhuchen1988/JAVA-000/tree/main/Week_05/homework/src/main/java/com/example/homework/xml
- annotation方式: 
https://github.com/tianzhuchen1988/JAVA-000/tree/main/Week_05/homework/src/main/java/com/example/homework/annotation
- 手动注册BeanDefinition方式: 
https://github.com/tianzhuchen1988/JAVA-000/tree/main/Week_05/homework/src/main/java/com/example/homework/beanDefinition
- FactoryBean方式装配了Spring Bean:
https://github.com/tianzhuchen1988/JAVA-000/tree/main/Week_05/homework/src/main/java/com/example/homework/factoryBean

#### 作业题目：给前面课程提供的 Student/Klass/School 实现自动配置和 Starter
- student-starter实现为Student自动装配及包装成starter
- hello-starter-demo依赖student-starter，并注入Student

#### 作业题目：研究一下 JDBC 接口和数据库连接池，掌握它们的设计和用法：
1）使用 JDBC 原生接口，实现数据库的增删改查操作。
2）使用事务，PrepareStatement 方式，批处理方式，改进上述操作。
3）配置 Hikari 连接池，改进上述操作。提交代码到 Github。
- jdbc-demo工程实现了以上功能，采用springboot+h2简化数据库配置及bean注入，具体的数据库操作采用原生JDBC实现
