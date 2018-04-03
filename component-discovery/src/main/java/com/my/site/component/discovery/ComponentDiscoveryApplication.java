package com.my.site.component.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ComponentDiscoveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(ComponentDiscoveryApplication.class, args);
	}
}
