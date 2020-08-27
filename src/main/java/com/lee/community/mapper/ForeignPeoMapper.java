package com.lee.community.mapper;

import com.lee.community.pojo.ForeignPeo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ForeignPeoMapper {
    List<ForeignPeo> queryForeignPeoByName(String personName);
    int deleteForeignByNo(String[] ids);
    int addForeignPeo(ForeignPeo foreignPeo);
    int updateOutTimeByNo(ForeignPeo foreignPeo);
}
