package com.test.springcloudorder.api.controller;

import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/*
    springcloud中调用服务接口有两种方式：rest ， fegin(springcloud)
 */

@RestController
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;      //RestTemplate是由springboot web组件提供

    @RequestMapping("/getOrder")
    public String getOrder() {
        //调用有两种方式：采用服务别名 ，直接调用
        String url = "http://eureka-member/getMember";
        String res = restTemplate.getForObject( url , String.class );
        System.out.println( "订单服务查询会员，调用会员服务！" );
        return res;
    }

//    // DiscoveryClient接口  可以获取注册中心上的实例信息
//    @Autowired
//    private DiscoveryClient discoveryClient;
//
//    @RequestMapping("/getServiceUrl")
//    public List<String> getServiceUrl() {
//        List<ServiceInstance> list = discoveryClient.getInstances("consul-member");
//        List<String> services = new ArrayList<>();
//        for (ServiceInstance serviceInstance : list) {
//            if (serviceInstance != null) {
//                services.add(serviceInstance.getUri().toString());
//            }
//        }
//        for (int i = 0; i < services.size(); i++) {
//            System.out.println( services.get( i ) );
//        }
//        return services;
//    }

}
