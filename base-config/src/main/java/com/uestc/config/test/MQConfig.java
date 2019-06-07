package com.uestc.config.test;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Configuration
public class MQConfig {
    final static String MQPRODUCER = "MQProducer";

    @Bean
    public Queue queueMQProducer() {
        return new Queue(MQPRODUCER);
    }
}
