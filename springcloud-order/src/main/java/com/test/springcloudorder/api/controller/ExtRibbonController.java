package com.test.springcloudorder.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/*
    手写ribbon本地负载均衡
        原理：在调用接口的时候，会在eureka注册中心上获取注册信息服务列表，缓存在本地jvm，相当于本地实现rpc远程调用
            即在客户端实现负载均衡。
    nginx是服务器负载均衡，客户端所有请求都交给nginx，然后转发请求。

    ribbon本地负载均衡，适合在微服务rpc远程调用，比如dubbo ， sprincloud
    nginx服务器负载均衡，针对服务器端，比如tomcat ， jetty
 */

@RestController
public class ExtRibbonController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private RestTemplate restTemplate;

    //接口总请求次数（需要清零）
    private int reqCount = 1;

    @RequestMapping("/ribbonMember")
    public String ribbonMember() {
        //获取对应服务器远程调用地址
        String instanceUri = getInstances() + "/getMember";
        System.out.println(instanceUri);
        //使用restTemplate或者直接使用httpClient远程调用服务
        String res = restTemplate.getForObject( instanceUri , String.class );
        return res;
    }

    public String getInstances() {
        List<ServiceInstance> list = discoveryClient.getInstances( "eureka-member" );
        if (list == null || list.size() == 0) {
            return null;
        }
        //获取服务器集群个数
        int instanceSize = list.size();
        //根据算法获取集群list的下标
        int instanceindex = reqCount % instanceSize;
        reqCount++;
        return list.get(instanceindex).getUri().toString();
    }

}
