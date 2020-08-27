package com.lee.community.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    // 测试管理员权限
    @PreAuthorize("hasAuthority('ROLE_NORMAL')")
    @RequestMapping( value = "/test/normal", method = RequestMethod.GET )
    public String test1() {
        return " normal接口调用成功！";
    }


    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @RequestMapping( value = "/test/admin", method = RequestMethod.GET )
    public String test2() {
        return "  admin接口调用成功！";
    }

}
