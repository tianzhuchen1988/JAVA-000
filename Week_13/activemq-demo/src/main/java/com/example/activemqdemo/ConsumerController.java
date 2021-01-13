package com.example.activemqdemo;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chentz
 * @version v1.0
 * @date 2021/1/13 15:26
 */
@RestController
public class ConsumerController {

    /**
     * queue模式下的消费
     *
     * @author chentz
     * @date 2021/1/13 15:32
     * @param message
     * @return void
     */
    @JmsListener(destination="active.queue")
    public void readActiveQueue(String message) {
        System.out.println("queue接受到：" + message);
    }

    /**
     * topic模式下的消费
     *
     * @author chentz
     * @date 2021/1/13 16:31
     * @param message
     * @return void
     */
    @JmsListener(destination="${spring.activemq.topic-name}", containerFactory="topicListener")
    public void readActiveQueueForTopic(String message) {
        System.out.println("topic接受到：" + message);
    }

}
