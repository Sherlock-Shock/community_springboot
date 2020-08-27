package com.lee.community.mapper;

import com.lee.community.pojo.Bunit;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface BunitMapper {
    int addUnit(Bunit bunit);
    List<Map> queryBunitByNo(Integer unitNo);
    int deleteUnits(int[] unitId);
    int updateUnitById(Bunit bunit);
    List<Integer> queryUnitNo();
    int checkUnitNoIsExist(Bunit bunit);
}
