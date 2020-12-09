package com.example.sharding.demo.controller;

import com.example.sharding.demo.entity.Order;
import com.example.sharding.demo.service.OrderServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author chentz
 * @version v1.0
 * @date 2020/12/9 13:02
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Resource
    private OrderServiceImpl orderService;

    @GetMapping("/findById/{id}")
    public Order findById(@PathVariable("id") Long id) {
        return orderService.findById(id);
    }

}
