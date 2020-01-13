package com.test.springcloudorder.api.controller;

import com.test.springcloudorder.feign.MemberApiFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*

 */

@RestController
public class FeignController {

    @Autowired
    private MemberApiFeign memberApiFeign;

    @RequestMapping("/getMemberFeign")
    public String getMemberFeign() {
        return memberApiFeign.getMember();
    }

}
