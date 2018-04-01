package com.yuanzhy.site.serviceblog.controller;

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
     * testRemote
     * @return
     */
    @GetMapping(value="testRemote")
    public String testRemote() {
        return restTemplate.getForObject("service-user", String.class);
    }
}
