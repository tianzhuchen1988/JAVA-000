package com.example.roomstate.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author chentz
 * @version v1.0
 * @date 2020/12/9 21:26
 */
@Data
public class RoomState implements Serializable {

    private Long id;

    private Integer status;

}
