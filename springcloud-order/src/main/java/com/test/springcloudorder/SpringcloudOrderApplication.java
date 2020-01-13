package com.test.springcloudorder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient        //将当前服务注册到erueka
//@EnableDiscoveryClient  //注册中心为zookeeper或者connsul的时候使用该注解
@EnableFeignClients		  //开启Feign权限
public class SpringcloudOrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudOrderApplication.class, args);
	}

	//解决restTemplate找不到 需要把restTemplate注册到springboot容器中 @Bean
	//如果restTemplate需要以别名方式启动的话需要依赖ribbon @LoadBalanced 在请求时让客户端拥有负载均衡高能力
	@Bean
	//@LoadBalanced
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
