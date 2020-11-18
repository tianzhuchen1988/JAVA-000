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
