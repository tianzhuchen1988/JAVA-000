package io.kimmking.dubbo.demo.consumer.controller;

import io.kimmking.dubbo.demo.api.IDealAService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author chentz
 * @version v1.0
 * @date 2020/12/15 20:19
 */
@RestController
@RequestMapping("/dealA")
public class DealAController {

    @Resource
    private IDealAService iDealAService;

    @GetMapping("/deal/{id}")
    public String deal(@PathVariable("id") Long id) {
        iDealAService.deal(id);
        return "success";
    }

}
