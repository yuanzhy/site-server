package com.my.site.service.blog.controller;

import com.my.site.service.blog.remote.UserServiceDemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class DemoConsumeController {
    @Autowired
    private RestTemplate restTemplate;

    /**
     * 测试远程调用，不适用断路器方式
     * testRemote
     * @return
     */
    @GetMapping(value="testRemote")
    public String testRemote() {
        System.out.println("远程调用了service-user");
        return "blog-service remote call user-service: " + restTemplate.getForObject("http://service-user/test", String.class);
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
        System.out.println("远程调用了支持断路器方式的service-user");
        return userService.userService();
    }

}
