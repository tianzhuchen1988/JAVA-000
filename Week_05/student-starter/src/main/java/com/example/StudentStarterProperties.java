package com.example;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author chentz
 * @version v1.0
 * @date 2020/11/18 15:40
 */
@ConfigurationProperties(prefix = "student")
public class StudentStarterProperties {

    private Integer id;

    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
