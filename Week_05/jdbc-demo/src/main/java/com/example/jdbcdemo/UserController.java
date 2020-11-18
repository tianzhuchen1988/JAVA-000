package com.example.jdbcdemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author chentz
 * @version v1.0
 * @date 2020/11/18 16:27
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("/save")
    public void save() {
        userService.save();
    }

    @GetMapping("/list")
    public List<Person> list() {
        return userService.query();
    }

    @GetMapping("/insert")
    public void insert() {
        userService.insert();
    }

}
