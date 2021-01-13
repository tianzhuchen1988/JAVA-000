package com.example.activemqdemo;

import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.jms.Queue;
import javax.jms.Topic;

/**
 * @author chentz
 * @version v1.0
 * @date 2021/1/13 15:25
 */
@RestController
public class ProducerController {

    @Resource
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Resource
    private Queue queue;

    @Resource
    private Topic topic;

    @RequestMapping("/sendmsg")
    public void sendmsg() {
        this.jmsMessagingTemplate.convertAndSend(this.queue, "hello");
    }

    @GetMapping("/topic/test")
    public String sendTopic() {
        this.jmsMessagingTemplate.convertAndSend(this.topic, "hello,topic");
        return "success";
    }

}
