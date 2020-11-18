package com.example.homework.annotation;

import com.example.homework.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author chentz
 * @version v1.0
 * @date 2020/11/18 14:11
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

    @Resource
    private User user;

    @GetMapping("/getUser")
    public User getUser() {
        return user;
    }
}

@Configuration
class DemoConfiguration {

    @Bean
    public User userName() {
        return new User(1001, "chentz");
    }

}
