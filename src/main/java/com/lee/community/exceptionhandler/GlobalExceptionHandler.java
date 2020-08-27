package com.lee.community.exceptionhandler;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BadCredentialsException.class)
    @ResponseBody
    public Object handleException(HttpServletRequest request, BadCredentialsException e){
        System.out.println("###出现异常！");
        Map<String,Object> map=new HashMap<>();
        map.put("url",request.getRequestURL().toString());
        map.put("msg",e.getMessage());
        return map;
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public Object handleRunTimeException(HttpServletRequest request, RuntimeException e){
        System.out.println("###出现运行时异常！");
        Map<String,Object> map=new HashMap<>();
        map.put("url",request.getRequestURL().toString());
        map.put("msg","运行异常"+e.getMessage());
        return map;
    }

}
