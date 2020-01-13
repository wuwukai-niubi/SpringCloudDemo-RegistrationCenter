package com.test.springcloudmember.api.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {

    @Value( "${server.port}" )
    private String serverPort;

    @RequestMapping("/getMember")
    public String getMember() {
        return "i am member,这是我的会员服务！" + serverPort;
    }

}
