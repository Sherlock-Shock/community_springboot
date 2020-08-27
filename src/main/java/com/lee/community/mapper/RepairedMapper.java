package com.lee.community.mapper;

import com.lee.community.pojo.Repaired;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface RepairedMapper {
    int addRepaired(Repaired repaired);
    Repaired queryRepairedOne(String repairNo);
    int updateRepairFinish(Repaired repaired);

}
