package com.my.site.service.blog.controller;

import com.my.site.service.blog.feign.UserFeignClientDemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yuanzhy on 2018/5/12.
 */
@RestController
public class DemoFeignConsumeController {
    @Autowired
    private UserFeignClientDemo userClient;

    @GetMapping("/testRemoteFeign")
    public String ListUsers() {
        return "使用feign形式调用远程user服务：" + this.userClient.test();
    }
}
