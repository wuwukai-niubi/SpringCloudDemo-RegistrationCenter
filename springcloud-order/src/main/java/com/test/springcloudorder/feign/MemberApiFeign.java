package com.test.springcloudorder.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/*
    springcloud支持两种远程调用工具 restTemplate基本不用，实际开发更多的是用feign
    feign是一个声明式的http远程调用工具，采用接口+注解方式实现，易读性比较强
        书写方式以spring mvc接口形式
        @FeignClient注解 name属性就是服务名称
 */


@FeignClient( name="eureka-member" )
public interface MemberApiFeign {

    @RequestMapping("/getMember")
    public String getMember();

}
