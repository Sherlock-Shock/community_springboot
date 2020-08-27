package com.lee.community.util;

import com.alibaba.fastjson.JSON;

import java.util.List;

public class FastJSONUtil {

    public static String bean2json(Object object){
        return JSON.toJSONString(object);
    }

    public static <T> T json2bean(String jsonStr,Class<T> objClass){
        return JSON.parseObject(jsonStr,objClass);

    }

    public static <T> List<T> json2beans(String jsonStr, Class<T> objClass){
        return JSON.parseArray(jsonStr,objClass);
    }

}
