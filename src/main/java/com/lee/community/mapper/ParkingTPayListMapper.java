package com.lee.community.mapper;

import com.lee.community.pojo.ParkingTPayList;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface ParkingTPayListMapper {
    int addParkingPaymentList(ParkingTPayList parkingTPayList);
    List<Map> queryTPPaymentList(@Param("licenseNo") String licenseNo,
                                 @Param("beginTime") String beginTime,
                                 @Param("overTime") String overTime);

}
