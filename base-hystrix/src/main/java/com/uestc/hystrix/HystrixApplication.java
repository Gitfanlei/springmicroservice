package com.uestc.hystrix;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients    //接口代理组件
@Controller
@EnableHystrixDashboard
@EnableHystrix// 断路器使能   与 @EnableCircuitBreaker 功能类似
@EnableCircuitBreaker
public class HystrixApplication {

    @RequestMapping(value = "/")
    @HystrixCommand(fallbackMethod = "fallback_home", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String home() {
        return "forward:/hystrix";
    }
    private String fallback_home() {
        return "Request fails. It takes long time to response";
    }


    public static void main(String[] args) {
        SpringApplication.run(HystrixApplication.class, args);
    }
}
