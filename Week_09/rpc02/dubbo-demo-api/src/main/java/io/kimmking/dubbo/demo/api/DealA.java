package io.kimmking.dubbo.demo.api;

import lombok.Data;

import java.io.Serializable;

/**
 * @author chentz
 * @version v1.0
 * @date 2020/12/15 20:17
 */
@Data
public class DealA implements Serializable {

    private Long id;

    private Integer dollar;

    private Integer rmb;

    private Integer freeze;

}

