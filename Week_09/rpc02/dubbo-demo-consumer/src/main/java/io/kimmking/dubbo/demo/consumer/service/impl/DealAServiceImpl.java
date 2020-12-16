package io.kimmking.dubbo.demo.consumer.service.impl;

import io.kimmking.dubbo.demo.api.IDealAService;
import io.kimmking.dubbo.demo.api.IDealBService;
import io.kimmking.dubbo.demo.consumer.mapper.DealAMapper;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.DubboService;
import org.dromara.hmily.annotation.HmilyTCC;

import javax.annotation.Resource;

/**
 * @author chentz
 * @version v1.0
 * @date 2020/12/15 20:21
 */
@DubboService(version = "1.0.0")
public class DealAServiceImpl implements IDealAService {

    @Resource
    private DealAMapper dealAMapper;

    @DubboReference(version = "1.0.0", url = "dubbo://127.0.0.1:12345")
    private IDealBService iDealBService;

    @Override
    @HmilyTCC(confirmMethod = "confirmDeal", cancelMethod = "cancelDeal")
    public void deal(long id) {
        dealAMapper.updateAccount(id);
        iDealBService.deal(id);
    }

    public void confirmDeal(long id) {
        dealAMapper.updateConfirmDeal(id);
    }

    public void cancelDeal(long id) {
        dealAMapper.updateCancelDeal(id);
    }
}
