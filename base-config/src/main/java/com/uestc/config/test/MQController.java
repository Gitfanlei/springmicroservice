package com.uestc.config.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Component
@RestController
public class MQController {
    @Autowired
    private MQProducer mqProducer;

    @RequestMapping(value = "/MQProducer")
    public String mqProcuderSend() {
        mqProducer.send();
        return "ok";
    }

}
