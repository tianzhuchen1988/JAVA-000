package com.example.sharding.demo.mapper;

import com.example.sharding.demo.entity.Order;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author chentz
 * @version v1.0
 * @date 2020/12/9 11:50
 */
@Mapper
public interface OrderMapper {

    Order findById(Long id);

}
