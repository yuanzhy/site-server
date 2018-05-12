package com.my.site.service.blog.feign;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by yuanzhy on 2018/5/12.
 * feign.hystrix.enabled=true 一定要配置这个，feign的熔断才会生效
 */
@FeignClient(name="user-service", fallback = UserFeignFallbackDemo.class)
public interface UserFeignClientDemo {

    @GetMapping(value="test")
    public String test();
}
