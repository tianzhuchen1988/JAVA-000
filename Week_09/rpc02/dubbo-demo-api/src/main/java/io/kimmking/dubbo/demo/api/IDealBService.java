package io.kimmking.dubbo.demo.api;

import org.dromara.hmily.annotation.Hmily;

/**
 * @author chentz
 * @version v1.0
 * @date 2020/12/15 20:36
 */
public interface IDealBService {
    @Hmily
    void deal(long id);
}
