package io.kimmking.dubbo.demo.provider.mapper;

import org.apache.ibatis.annotations.Mapper;

/**
 * @author chentz
 * @version v1.0
 * @date 2020/12/15 20:36
 */
@Mapper
public interface DealBMapper {
    void updateAccount(long id);

    void updateConfirmDeal(long id);

    void updateCancelDeal(long id);
}
