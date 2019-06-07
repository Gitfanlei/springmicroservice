package com.uestc.config.test;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "MQProducer")   // 监听 key
public class MQConsumer {
    @RabbitHandler
    public void process(String[] args) {
        System.out.println("MQConsumer 接收消息:" + args);
    }
}
