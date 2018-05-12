package com.my.site.service.blog.controller;

import com.my.site.service.blog.remote.UserServiceDemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RefreshScope
public class DemoRibbonConsumeController {
    @Autowired
    private RestTemplate restTemplate;

    /**
     * 使用了ribbon，客户端负载均衡
     * 1. 在SpringBootApplication添加 @Bean @LoadBalance 返回RestTemplate
     * 2. 注入restTemplate，调用getForObject等方法，http://服务名/rest名
     * 测试远程调用，不适用断路器方式
     * testRemote
     * @return
     */
    @GetMapping(value="testRemote")
    public String testRemote() {
        System.out.println("远程调用了user-service");
        return "blog-service remote call user-service: " + restTemplate.getForObject("http://user-service/test", String.class);
    }

    /**
     * 支持断路器的远程调用方式
     */
    @Autowired
    private UserServiceDemo userService;
    /**
     * 测试远程调用断路器方式
     * @return
     */
    @GetMapping(value="testRemoteFB")
    public String testRemoteFB() {
        System.out.println("远程调用了支持断路器方式的user-service");
        return "远程调用了支持断路器方式的user-service：" + userService.userService();
    }

    /**
     * 本地的配置
     */
    @Value("${server.port}")
    private String port;
    /**
     * config server的配置
     */
    @Value("${blog.test}")
    private String test;
    /**
     * config server的配置
     */
//    @Value("${config.test}")
    private String configTest;
    /**
     * 测试config server中获取config
     * @return
     */
    @GetMapping(value="testConfig")
    public String testConfig() {
        return "port: " + port + ", test: " + test + ", configTest: " + configTest;
    }

}
