package com.example.homework.xml;

import com.example.homework.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 使用xml定义beanDefinition
 *
 * @author chentz
 * @version v1.0
 * @date 2020/11/18 14:30
 */
public class XmlBeanTest {
    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:spring-application.xml");

        User user = (User) beanFactory.getBean("user");
        System.out.println(user);

    }
}
