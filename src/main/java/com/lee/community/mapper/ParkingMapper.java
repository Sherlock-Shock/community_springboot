package com.lee.community.mapper;

import com.lee.community.pojo.Parking;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface ParkingMapper {
    int addParking(Parking parking);
    List<Map> queryParkingByNo(String parkingNo);
    int deleteParkings(int[] ids);
    int updateParkingById(Parking parking);
    List<Map> queryParkingAndOwner(@Param("parkingNo")String parkingNo, @Param("ownerName")String ownerName);
    int queryParkingTotal();
    List<Map> queryOwnerAllParking(String ownerId);
    int updateParkingOwnerDrop(String parkId);
    List<Parking> queryParkingFree(String parkingAreaId);
    int updateParkingOwnerBind(Parking parking);
    int checkParkingNoIsExist(Parking parking);
    Map queryParkingPie();

}
