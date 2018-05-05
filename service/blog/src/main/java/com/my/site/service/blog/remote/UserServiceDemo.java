package com.my.site.service.blog.remote;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.command.AsyncResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.Future;

/**
 * feign 调用远程服务
 * 远程调用，使用断路器方式的本地service stub
 * @Author Administrator
 * @Date 2018/4/4
 */
@Service
public class UserServiceDemo {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "userServiceFallback")
    public String userService() {
        return restTemplate.getForObject("http://user-service/test", String.class);
    }

    /**
     * 异步版本
     * @return
     */
    @HystrixCommand(fallbackMethod = "userServiceFallback")
//    @HystrixCommand(fallbackMethod = "userServiceFallback",
//            ignoreExceptions = {RuntimeException.class}, // 忽略异常配置，此异常不走fallback
//            groupKey = "testGroupName", // 组名 -> 线程池隔离默认按组名划分
//            commandKey = "testCommandKey")
    public Future<String> userServiceAsync() {
        return new AsyncResult<String>() {
            @Override
            public String invoke() {
                return restTemplate.getForObject("http://user-service/test", String.class);
            }
        };
    }

    /**
     * 断路器fallback方法
     * 该方法也可能通过网络数据库等请求而发成异常，也可以添加@HystrixCommand 并实现二级fallback函数，俗称服务降级
     * @return
     */
    private String userServiceFallback(Throwable e) {
        System.out.println("正常调用发生了异常: " + e.fillInStackTrace());
        return "service user is not available, hystrix take effect";
    }
}
