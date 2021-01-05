package com.example.redisdemo;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.integration.redis.util.RedisLockRegistry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

/**
 * @author chentz
 * @version v1.0
 * @date 2021/1/5 18:02
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

    @Resource
    private RedisLockRegistry redisLockRegistry;

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 分布式锁测试
     *
     * @author chentz
     * @date 2021/1/5 19:26
     * @param
     * @return java.lang.String
     */
    @GetMapping("/lockTest")
    public String lockTest() {
        Lock lock = redisLockRegistry.obtain("demo-key");
        try {
            lock.tryLock(5, TimeUnit.SECONDS);
            System.out.println("获取分布式锁成功");
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            lock.unlock();
        }
        return "success";
    }

    /**
     * 模拟分布式计数器减库存测试
     *
     * @author chentz
     * @date 2021/1/5 19:26
     * @param
     * @return java.lang.String
     */
    @GetMapping("/stockTest")
    public String stockTest() {
        redisTemplate.opsForValue().set("stock", 10);
        Thread t1 = new Thread(() -> {
            while(true) {
                Lock lock = redisLockRegistry.obtain("demo-key");
                try {
                    lock.tryLock(5, TimeUnit.SECONDS);
                    Integer stock = (Integer)redisTemplate.opsForValue().get("stock");
                    if (stock == 0) {
                        System.out.println("没有库存可扣了...");
                        break;
                    }
                    redisTemplate.opsForValue().decrement("stock");
                } catch (Exception ex) {
                    ex.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        });
        Thread t2 = new Thread(() -> {
            while(true) {
                Lock lock = redisLockRegistry.obtain("demo-key");
                try {
                    lock.tryLock(5, TimeUnit.SECONDS);
                    Integer stock = (Integer)redisTemplate.opsForValue().get("stock");
                    if (stock == 0) {
                        System.out.println("没有库存可扣了...");
                        break;
                    }
                    redisTemplate.opsForValue().decrement("stock");
                } catch (Exception ex) {
                    ex.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        });

        t1.start();
        t2.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "success";
    }

    /**
     * redis发布订阅测试
     *
     * @author chentz
     * @date 2021/1/5 19:57
     * @param
     * @return java.lang.String
     */
    @GetMapping("/createOrder")
    public String createOrder() {
        redisTemplate.convertAndSend("mq_01", "创建订单成功...");
        return "success";
    }

}
