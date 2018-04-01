package com.thunisoft.site.service.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
//    @Autowired
//    private DiscoveryClient discoveryClient;
    @GetMapping(value="test")
    public String test() {
        return "this is user-service";
    }
}
