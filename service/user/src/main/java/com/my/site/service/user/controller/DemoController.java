package com.my.site.service.user.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

@RestController
public class DemoController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
//    @Autowired
//    private DiscoveryClient discoveryClient;
    @GetMapping(value="test")
    public String test(HttpServletRequest request) {
        Enumeration<String> e = request.getHeaderNames();
        while (e.hasMoreElements()) {
            String name = e.nextElement();
            logger.info("--header--{}: {}", name, request.getHeader(name));
        }
        logger.info("call user-service, TraceId={},SpanId={},", request.getHeader("X-B3-TraceId"),request.getHeader("X-B3-SpanId"));
        return "this is user-service";
    }
}
