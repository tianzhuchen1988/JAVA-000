package com.example.order.client;

import com.example.order.entity.RoomState;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author chentz
 * @version v1.0
 * @date 2020/12/9 21:41
 */
@FeignClient(value = "room-state")
public interface RoomStateClient {

    @GetMapping("/roomstate/findById/{id}")
    RoomState findById(@PathVariable("id") Long id);
}
