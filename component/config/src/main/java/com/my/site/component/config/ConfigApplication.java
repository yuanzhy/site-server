package com.my.site.component.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * 和SpringCloudBus整合说明：
 * 1. 引入spring-cloud-starter-bus-amqp
 * 2. 配置rabbitMQ连接信息，spring.rabbitmq.hostname  port  username  password
 * 3. 不整合暴漏的刷新端点是/actuator/refresh 整合后是 /actuator/bus-refresh
 * 4. 服务发现下，post（git web hooker）访问其中一个点的/actuator/bus-refresh接口，
 *    即可实现多服务实例配置同步刷新。依托rabbitmq的消息总线生效了。建议这个点是config-server，简化集群维护成本
 * 5. 可以传递参数指定要刷新哪个服务
 *    /actuator/bus-refresh?destination=blog:9000 刷新blog端口9000的服务
 *    /actuator/bus-refresh?destination=blog:** 刷新所有blog服务实例
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableConfigServer
public class ConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigApplication.class, args);
    }
}
