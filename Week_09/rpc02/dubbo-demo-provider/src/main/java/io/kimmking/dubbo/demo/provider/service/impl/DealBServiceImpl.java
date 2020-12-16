package io.kimmking.dubbo.demo.provider.service.impl;

import io.kimmking.dubbo.demo.api.IDealBService;
import io.kimmking.dubbo.demo.provider.mapper.DealBMapper;
import org.apache.dubbo.config.annotation.DubboService;
import org.dromara.hmily.annotation.HmilyTCC;

import javax.annotation.Resource;

/**
 * @author chentz
 * @version v1.0
 * @date 2020/12/15 20:37
 */
@DubboService(version = "1.0.0")
public class DealBServiceImpl implements IDealBService {

    @Resource
    private DealBMapper dealBMapper;

    @Override
    @HmilyTCC(confirmMethod = "confirmDeal", cancelMethod = "cancelDeal")
    public void deal(long id) {
        dealBMapper.updateAccount(id);
        throw new RuntimeException();
    }

    public void confirmDeal(long id) {
        dealBMapper.updateConfirmDeal(id);
    }

    public void cancelDeal(long id) {
        dealBMapper.updateCancelDeal(id);
    }
}
