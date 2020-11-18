package com.example;

import lombok.Data;

/**
 * @author chentz
 * @version v1.0
 * @date 2020/11/18 15:39
 */
@Data
public class Student {

    private Integer id;

    private String name;

    public void sayHello() {
        System.out.println("Hello, starter!");
    }

}
