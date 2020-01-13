package com.test.springcloudmember;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient        //将当前服务注册到erueka
//@EnableDiscoveryClient  //注册中心为zookeeper或者connsul的时候使用该注解
public class SpringcloudMemberApplication {

    public static void main(String[] args) {
        SpringApplication.run( SpringcloudMemberApplication.class, args );
    }

}
