package com.example.roomstate.service;

import com.example.roomstate.entity.RoomState;
import com.example.roomstate.mapper.RoomStateMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author chentz
 * @version v1.0
 * @date 2020/12/9 21:27
 */
@Service
public class RoomStateServiceImpl {

    @Resource
    private RoomStateMapper roomStateMapper;

    public RoomState findById(Long id) {
        return roomStateMapper.findById(id);
    }
}
