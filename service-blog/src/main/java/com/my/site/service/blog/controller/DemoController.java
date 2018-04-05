package com.my.site.service.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class DemoController {
    @Autowired
    private RestTemplate restTemplate;

    /**
     * testRemote
     * @return
     */
    @GetMapping(value="testRemote")
    public String testRemote() {
        System.out.println("远程调用了service-user");
        return "blog-service remote call user-service: " + restTemplate.getForObject("http://service-user/test", String.class);
    }
}
