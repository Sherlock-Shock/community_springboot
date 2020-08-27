package com.lee.community.mapper;

import com.lee.community.pojo.ParkRecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface ParkRecordMapper {
    List<Map> queryParkRecord(@Param("licenseNo")String licenseNo,@Param("parkingAreaNo")String parkingAreaNo);
    int deleteParkRecord(String[] ids);
    int addParkRecord(ParkRecord parkRecord);
    int updateOutTimeById(ParkRecord parkRecord);
}
