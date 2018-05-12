package com.my.site.service.blog.feign;

import org.springframework.stereotype.Component;

/**
 * Created by yuanzhy on 2018/5/12.
 */
@Component
public class UserFeignFallbackDemo implements UserFeignClientDemo {
    @Override
    public String test() {
        return "调用失败熔断了";
    }
}
