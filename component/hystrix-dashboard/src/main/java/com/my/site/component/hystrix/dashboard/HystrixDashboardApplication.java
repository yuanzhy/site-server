package com.my.site.component.hystrix.dashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * HystrixDashboard项目同时引入了turbine支持
 *
 * 单独：http://localhost:7777/actuator/hystrix.stream
 * turbine默认：http://localhost:8333/turbine.stream
 * turbine集群：http://localhost:8333/turbine.stream?cluster=xxx
 */
@EnableDiscoveryClient
@EnableHystrixDashboard
@EnableTurbine
@SpringBootApplication
public class HystrixDashboardApplication {

    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboardApplication.class, args);
    }
}
