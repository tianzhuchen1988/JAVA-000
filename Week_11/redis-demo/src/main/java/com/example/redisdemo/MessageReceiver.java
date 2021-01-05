package com.example.redisdemo;

import org.springframework.stereotype.Component;

/**
 * @author chentz
 * @version v1.0
 * @date 2021/1/5 19:59
 */
@Component
public class MessageReceiver {

    /**
     * 接收消息的方法
     **/
    public void receiveMessage(String message){
        System.out.println("receiveMessage接收到的消息："+ message);
    }


}
