package com.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author chentz
 * @version v1.0
 * @date 2020/11/18 15:54
 */
@RestController
@RequestMapping("/demo")
public class HelloStartDemoController {

    @Resource
    private Student student;

    @GetMapping("/getStudent")
    public Student getStudent() {
        return student;
    }

}
