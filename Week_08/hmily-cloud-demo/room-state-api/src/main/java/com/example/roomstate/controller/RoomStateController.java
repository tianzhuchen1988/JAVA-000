package com.example.roomstate.controller;

import com.example.roomstate.entity.RoomState;
import com.example.roomstate.service.RoomStateServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author chentz
 * @version v1.0
 * @date 2020/12/9 21:30
 */
@RestController
@RequestMapping("/roomstate")
public class RoomStateController {

    @Resource
    private RoomStateServiceImpl roomStateService;

    @GetMapping("/findById/{id}")
    public RoomState findById(@PathVariable("id") Long id) {
        return roomStateService.findById(id);
    }

    @GetMapping("/updateStatus/{id}")
    public void updateStatus(@PathVariable("id") Long id) {
        roomStateService.updateStatus(id);
    }
}
