package com.my.site.service.blog.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class DemoController {
    @Autowired
    private RestTemplate restTemplate;

    /**
     * 使用了ribbon，客户端负载均衡
     * 1. 在SpringBootApplication添加 @Bean @LoadBalance 返回RestTemplate
     * 2. 注入restTemplate，调用getForObject等方法，http://服务名/rest名
     * testRemote
     * @return
     */
    @GetMapping(value="testRemote")
    public String testRemote() {
        System.out.println("远程调用了service-user");
        return "blog-service remote call user-service: " + restTemplate.getForObject("http://service-user/test", String.class);
    }
}
