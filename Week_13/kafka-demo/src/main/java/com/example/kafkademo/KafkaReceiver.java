package com.example.kafkademo;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author chentz
 * @version v1.0
 * @date 2021/1/13 19:38
 */
@Component
public class KafkaReceiver {

    @KafkaListener(topics = {"test-topic"})
    public void listen(ConsumerRecord<?, ?> record) {
        Optional<?> kafkaMessage = Optional.ofNullable(record.value());
        if (kafkaMessage.isPresent()) {
            Object message = kafkaMessage.get();
            System.out.println(record);
            System.out.println(message);
        }
    }

}
