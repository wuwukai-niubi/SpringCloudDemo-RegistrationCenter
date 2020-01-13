package com.test.springcloudeurake;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/*
	eureka使用@EnableEurekaServer启动服务
	zookeeper与consul需要启动包启动
 */

@SpringBootApplication
@EnableEurekaServer
public class SpringcloudEurake2Application {

	public static void main(String[] args) {
		SpringApplication.run( SpringcloudEurake2Application.class, args);
	}

}
