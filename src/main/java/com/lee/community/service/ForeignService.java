package com.lee.community.service;

import com.lee.community.pojo.ForeignPeo;

import java.util.List;

public interface ForeignService {
    List<ForeignPeo> queryForeignPeoByName(String personName);
    int deleteForeignByNo(String[] ids);
    int addForeignPeo(ForeignPeo foreignPeo);
    int updateOutTimeByNo(ForeignPeo foreignPeo);
}
