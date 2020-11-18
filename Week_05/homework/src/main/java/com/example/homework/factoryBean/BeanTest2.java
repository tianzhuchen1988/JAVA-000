package com.example.homework.factoryBean;

import com.example.homework.User;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author chentz
 * @version v1.0
 * @date 2020/11/18 14:54
 */
@Configuration
@ComponentScan("com.example.homework.factoryBean")
public class BeanTest2 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeanTest2.class);
        User user = (User) applicationContext.getBean("userFactoryBean");
        System.out.println(user);
    }
}

@Component
class UserFactoryBean implements FactoryBean {

    @Override
    public Object getObject() throws Exception {
        return new User(1004, "chentz");
    }

    @Override
    public Class<?> getObjectType() {
        return User.class;
    }
}
