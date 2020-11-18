package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author chentz
 * @version v1.0
 * @date 2020/11/18 15:42
 */
@Configuration
@EnableConfigurationProperties(StudentStarterProperties.class)
public class StudentAutoConfiguration {

    @Autowired
    private StudentStarterProperties studentStarterProperties;

    @Bean
    @ConditionalOnMissingBean(Student.class)
    public Student student() {
        Student student = new Student();
        student.setId(studentStarterProperties.getId());
        student.setName(studentStarterProperties.getName());
        return student;
    }

}
