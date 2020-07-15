package com.lee.community.controller;

import com.lee.community.dto.ResultJSON;
import com.lee.community.pojo.LoginInfo;
import com.lee.community.pojo.Users;
import com.lee.community.service.AuthService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.security.sasl.AuthenticationException;

@RestController
public class LoginController {


    @Autowired
    private AuthService authService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResultJSON createToken(String userid, String password ) throws AuthenticationException {
        System.out.println("controller中的："+userid+password);
        LoginInfo loginInfo = new LoginInfo();
        try {
            loginInfo = authService.login(userid, password);
        }catch(BadCredentialsException e){
            return new ResultJSON("1001","账号或密码错误",loginInfo);
        }
        loginInfo=authService.login( userid, password );
        //authService.login( userid, password ); // 登录成功会返回JWT Token给用户
        return new ResultJSON("200","登陆成功",loginInfo);
    }


}
