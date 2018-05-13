package com.my.site.component.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import zipkin.server.internal.EnableZipkinServer;

@SpringBootApplication
@EnableZipkinServer
//@Configuration
public class ZipkinServerApplication/* implements WebMvcConfigurer */{

	public static void main(String[] args) {
		SpringApplication.run(ZipkinServerApplication.class, args);
	}

//    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/").setViewName( "redirect:/zipkin/" );
//        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
//    }

}
