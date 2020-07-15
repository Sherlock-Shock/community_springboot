package com.lee.community.serviceimpl;

import com.lee.community.mapper.ParkRecordMapper;
import com.lee.community.mapper.ParkingAreaMapper;
import com.lee.community.mapper.ParkingMapper;
import com.lee.community.mapper.ParkingRentMapper;
import com.lee.community.pojo.ParkRecord;
import com.lee.community.pojo.Parking;
import com.lee.community.pojo.ParkingArea;
import com.lee.community.pojo.ParkingRent;
import com.lee.community.service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class ParkingServiceImpl implements ParkingService {
    @Autowired
    ParkingAreaMapper parkingAreaMapper;
    @Autowired
    ParkingMapper parkingMapper;
    @Autowired
    ParkRecordMapper parkRecordMapper;
    @Autowired
    ParkingRentMapper parkingRentMapper;

    @Override
    public List<ParkingArea> queryParkingAreaByNo(String parkingAreaNo) {
        return parkingAreaMapper.queryParkingAreaByNo(parkingAreaNo);
    }

    @Override
    public List<Integer> queryParkingAreaId() {
        return parkingAreaMapper.queryParkingAreaId();
    }

    @Override
    public int deleteParkingAreas(int[] ids) {
        return parkingAreaMapper.deleteParkingAreas(ids);
    }

    @Override
    public int updateParkingAreaById(ParkingArea parkingArea) {
        return parkingAreaMapper.updateParkingAreaById(parkingArea);
    }

    @Override
    public int addParkingArea(ParkingArea parkingArea) {
        return parkingAreaMapper.addParkingArea(parkingArea);
    }

    @Override
    public int checkParkingAreaNoIsExist(ParkingArea parkingArea) {
        return parkingAreaMapper.checkParkingAreaNoIsExist(parkingArea);
    }

    //车位
    @Override
    public int addParking(Parking parking) {
        return parkingMapper.addParking(parking);
    }

    @Override
    public List<Map> queryParkingByNo(String parkingNo) {
        return parkingMapper.queryParkingByNo(parkingNo);
    }

    @Override
    public int deleteParkings(int[] ids) {
        return parkingMapper.deleteParkings(ids);
    }

    @Override
    public int updateParkingById(Parking parking) {
        return parkingMapper.updateParkingById(parking);
    }

    @Override
    public int updateParkingOwnerDrop(String parkId) {
        return parkingMapper.updateParkingOwnerDrop(parkId);
    }

    @Override
    public List<Map> queryOwnerAllParking(String ownerId) {
        return parkingMapper.queryOwnerAllParking(ownerId);
    }

    @Override
    public List<Parking> queryParkingFree(String parkingAreaId) {
        return parkingMapper.queryParkingFree(parkingAreaId);
    }

    @Override
    public int addParkingRent(ParkingRent parkingRent) {
        return parkingRentMapper.addParkingRent(parkingRent);
    }

    @Override
    public int updateParkingOwnerBind(Parking parking) {
        return parkingMapper.updateParkingOwnerBind(parking);
    }

    @Override
    public int deleteParkingRent(String parkId) {
        return parkingRentMapper.deleteParkingRent(parkId);
    }

    @Override
    public int checkParkingNoIsExist(Parking parking) {
        return parkingMapper.checkParkingNoIsExist(parking);
    }

    @Override
    public Map queryParkingPie() {
        return parkingMapper.queryParkingPie();
    }
    //进出场信息

    @Override
    public List<Map> queryParkRecord(String licenseNo,String parkingAreaNo) {
        return parkRecordMapper.queryParkRecord(licenseNo,parkingAreaNo);
    }

    @Override
    public int deleteParkRecord(String[] ids) {
        return parkRecordMapper.deleteParkRecord(ids);
    }

    @Override
    public int addParkRecord(ParkRecord parkRecord) {
        parkRecord.setParkRecordId("110"+String.valueOf(new Date().getTime()));
        return parkRecordMapper.addParkRecord(parkRecord);
    }

    @Override
    public int updateOutTimeById(ParkRecord parkRecord) {
        return parkRecordMapper.updateOutTimeById(parkRecord);
    }

    @Override
    public List<Map> queryParkingAndOwner(String parkingNo, String ownerName) {
        return parkingMapper.queryParkingAndOwner(parkingNo,ownerName);
    }

    @Override
    public int queryParkingTotal() {
        return parkingMapper.queryParkingTotal();
    }
}
