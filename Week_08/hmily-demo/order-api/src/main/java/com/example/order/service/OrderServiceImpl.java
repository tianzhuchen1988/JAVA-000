package com.example.order.service;

import com.example.order.entity.Order;
import com.example.order.mapper.OrderMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author chentz
 * @version v1.0
 * @date 2020/12/9 13:01
 */
@Service
public class OrderServiceImpl {

    @Resource
    private OrderMapper orderMapper;

    public Order findById(Long id) {
        return orderMapper.findById(id);
    }

}
