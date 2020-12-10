package com.example.roomstate.service;

import com.example.roomstate.entity.RoomState;
import com.example.roomstate.mapper.RoomStateMapper;
import lombok.extern.slf4j.Slf4j;
import org.dromara.hmily.annotation.HmilyTAC;
import org.dromara.hmily.annotation.HmilyTCC;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author chentz
 * @version v1.0
 * @date 2020/12/9 21:27
 */
@Service
@Slf4j
public class RoomStateServiceImpl implements IRoomStateService {

    @Resource
    private RoomStateMapper roomStateMapper;

    public RoomState findById(Long id) {
        return roomStateMapper.findById(id);
    }

    @HmilyTCC(confirmMethod = "confirmRoomStateStatus", cancelMethod = "cancelRoomStateStatus")
    public void updateStatus(Long id) {
        roomStateMapper.updateStatus(id);
        throw new RuntimeException();
    }

    public void confirmRoomStateStatus(Long id) {
        log.info("==========执行state-confirm=============");
        roomStateMapper.updateConfirm(id);
    }

    public void cancelRoomStateStatus(Long id) {
        log.info("==========执行state-cancel=============");
        roomStateMapper.updateCancel(id);
    }
}
