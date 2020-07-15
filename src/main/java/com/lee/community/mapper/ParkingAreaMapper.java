package com.lee.community.mapper;

import com.lee.community.pojo.ParkingArea;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ParkingAreaMapper {
    List<ParkingArea> queryParkingAreaByNo(String parkingAreaNo);
    int deleteParkingAreas(int[] ids);
    int updateParkingAreaById(ParkingArea parkingArea);
    int addParkingArea(ParkingArea parkingArea);
    List<Integer> queryParkingAreaId();
    int checkParkingAreaNoIsExist(ParkingArea parkingArea);

}
