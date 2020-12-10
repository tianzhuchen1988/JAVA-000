package com.example.roomstate.mapper;

import com.example.roomstate.entity.RoomState;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author chentz
 * @version v1.0
 * @date 2020/12/9 21:26
 */
@Mapper
public interface RoomStateMapper {

    RoomState findById(long id);

    void updateStatus(Long id);

    void updateConfirm(Long id);

    void updateCancel(Long id);
}
