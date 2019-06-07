package com.uestc.config.test;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class MQProducer {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send() {
        String sendMsg = " hello, this is a test msg!" + new Date();
        System.out.println("MQProducer 发送消息：" + sendMsg);
        this.rabbitTemplate.convertAndSend("MQProducer", sendMsg); //消息队列  key:value
    }
}
