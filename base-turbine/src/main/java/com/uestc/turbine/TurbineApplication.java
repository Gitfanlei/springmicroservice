package com.uestc.turbine;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@Controller
@EnableEurekaClient
@EnableHystrixDashboard
@EnableHystrix
@EnableTurbine
@EnableCircuitBreaker
public class TurbineApplication {

    @RequestMapping(value = "/")
    @HystrixCommand(fallbackMethod = "fallback_home", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")
    })
    public String home() {
        return "forward:/hystrix";
    }
    private String fallback_home() {
        return "Request fails. It takes long time to response";
    }

    public static void main(String[] args) {
        SpringApplication.run(TurbineApplication.class, args);
    }
}
