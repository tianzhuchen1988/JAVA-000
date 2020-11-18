package com.example.homework.beanDefinition;

import com.example.homework.User;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 手动创建beanDefinition并注册到spring容器中
 *
 * @author chentz
 * @version v1.0
 * @date 2020/11/18 14:37
 */
public class BeanTest {

    public static void main(String[] args) {
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);

        beanDefinitionBuilder
                .addPropertyValue("id", 1003)
                .addPropertyValue("userName", "chentz");

        BeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.refresh();

        applicationContext.registerBeanDefinition("user", beanDefinition);

        User user = (User) applicationContext.getBean("user");
        System.out.println(user);
    }


}
