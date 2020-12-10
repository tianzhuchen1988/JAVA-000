package com.example.order.service;

import com.example.order.client.RoomStateClient;
import com.example.order.entity.Order;
import com.example.order.mapper.OrderMapper;
import lombok.extern.slf4j.Slf4j;
import org.dromara.hmily.annotation.HmilyTCC;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author chentz
 * @version v1.0
 * @date 2020/12/9 13:01
 */
@Service
@Slf4j
public class OrderServiceImpl implements IOrderService {

    @Resource
    private OrderMapper orderMapper;

    @Resource
    private RoomStateClient roomStateClient;

    public Order findById(Long id) {
        return orderMapper.findById(id);
    }

    @HmilyTCC(confirmMethod = "confirmOrderStatus", cancelMethod = "cancelOrderStatus")
    public void updateStatus(Long id) {
        orderMapper.updateStatus(id);
        roomStateClient.updateStatus(id);
    }

    public void confirmOrderStatus(Long id) {
        log.info("==========执行order-confirm=============");
        orderMapper.updateConfirm(id);
    }

    public void cancelOrderStatus(Long id) {
        log.info("==========执行order-cancel=============");
        orderMapper.updateCancel(id);
    }
}
