package com.lee.community.service;

import com.lee.community.pojo.ParkRecord;
import com.lee.community.pojo.Parking;
import com.lee.community.pojo.ParkingArea;
import com.lee.community.pojo.ParkingRent;

import java.util.List;
import java.util.Map;

public interface ParkingService {
    //停车场
    List<ParkingArea> queryParkingAreaByNo(String parkingAreaNo);
    int deleteParkingAreas(int[] ids);
    int updateParkingAreaById(ParkingArea parkingArea);
    int addParkingArea(ParkingArea parkingArea);
    List<Integer> queryParkingAreaId();
    int checkParkingAreaNoIsExist(ParkingArea parkingArea);

    //车位
    int addParking(Parking parking);
    List<Map> queryParkingByNo(String parkingNo);
    int deleteParkings(int[] ids);
    int updateParkingById(Parking parking);
    List<Map> queryParkingAndOwner(String parkingNo,String ownerName);
    int queryParkingTotal();
    List<Map> queryOwnerAllParking(String ownerId);
    int updateParkingOwnerDrop(String parkId);
    List<Parking> queryParkingFree(String parkingAreaId);
    int addParkingRent(ParkingRent parkingRent);
    int updateParkingOwnerBind(Parking parking);
    int deleteParkingRent(String parkId);
    int checkParkingNoIsExist(Parking parking);
    Map queryParkingPie();

    //进出场信息
    List<Map> queryParkRecord(String licenseNo,String parkingAreaNo);
    int deleteParkRecord(String[] ids);
    int addParkRecord(ParkRecord parkRecord);
    int updateOutTimeById(ParkRecord parkRecord);
}
