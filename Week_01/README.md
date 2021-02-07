## 1.（选做）自己写一个简单的 Hello.java，里面需要涉及基本类型，四则运行，if 和 for，然后自己分析一下对应的字节码
- https://github.com/tianzhuchen1988/JAVA-000/blob/main/Week_01/%E7%AE%80%E5%8D%95%E5%9B%9B%E5%88%99%2Bif%2Bfor%E5%BE%AA%E7%8E%AF%E7%BF%BB%E8%AF%91%E6%88%90%E7%9A%84%E5%AD%97%E8%8A%82%E7%A0%81%E6%8C%87%E4%BB%A4.jpg
## 2.（必做）自定义一个 Classloader，加载一个 Hello.xlass 文件，执行 hello 方法，此文件内容是一个 Hello.class 文件所有字节（x=255-x）处理后的文件。文件群里提供。
- https://github.com/tianzhuchen1988/JAVA-000/blob/main/Week_01/HelloClassLoader.java
## 3.（必做）画一张图，展示 Xmx、Xms、Xmn、Meta、DirectMemory、Xss 这些内存参数的关系。
- https://github.com/tianzhuchen1988/JAVA-000/blob/main/Week_01/java%E5%B8%B8%E8%A7%81%E5%86%85%E5%AD%98%E5%8F%82%E6%95%B0%E5%85%B3%E7%B3%BB%E5%9B%BE.png
## 4.（选做）检查一下自己维护的业务系统的 JVM 参数配置，用 jstat 和 jstack、jmap 查看一下详情，并且自己独立分析一下大概情况，思考有没有不合理的地方，如何改进。
因为线上没有权限查看，所以只能使用开发环境的JVM参数配置
- jstat -gc 10221 1000 1000 查看当前GC的情况
![image](https://github.com/tianzhuchen1988/JAVA-000/blob/main/Week_01/1612682070366.jpg)
