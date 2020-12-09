package com.example.order.controller;

import com.example.order.client.RoomStateClient;
import com.example.order.entity.Order;
import com.example.order.entity.RoomState;
import com.example.order.service.OrderServiceImpl;
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

    @Resource
    private RoomStateClient roomStateClient;

    @GetMapping("/findById/{id}")
    public Order findById(@PathVariable("id") Long id) {
        return orderService.findById(id);
    }

    @GetMapping("/feignById/{id}")
    public RoomState feignById(@PathVariable("id") Long id) {
        return roomStateClient.findById(id);
    }

}
