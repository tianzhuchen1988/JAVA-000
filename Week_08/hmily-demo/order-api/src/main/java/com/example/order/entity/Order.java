package com.example.order.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author chentz
 * @version v1.0
 * @date 2020/12/9 21:01
 */
@Data
public class Order implements Serializable {

    private Long id;

    private Integer status;

}
