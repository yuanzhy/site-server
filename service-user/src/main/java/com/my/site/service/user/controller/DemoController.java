package com.my.site.service.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
//    @Autowired
//    private DiscoveryClient discoveryClient;
    @GetMapping(value="test")
    public String test() {
        return "this is user-service";
    }
}
