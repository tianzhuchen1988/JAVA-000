package com.example.sharding.demo.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author chentz
 * @version v1.0
 * @date 2020/12/9 11:47
 */
@Data
public class Order implements Serializable {

    private Long id;

    private Long orderNo;

    private Long userId;

    private String address;

    private String mobile;

    private Long productCode;

    private BigDecimal price;

    private Integer productQuantity;

    private BigDecimal orderAmount;

    private Byte status;

    private Long createTime;

    private Long updateTime;

    private Byte deleteSign;

}
