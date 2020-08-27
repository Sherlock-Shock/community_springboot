package com.lee.community.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lee.community.dto.PageListJSON;
import com.lee.community.pojo.ParkRecord;
import com.lee.community.pojo.Parking;
import com.lee.community.pojo.ParkingArea;
import com.lee.community.pojo.ParkingRent;
import com.lee.community.service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
public class ParkingController {
    @Autowired
    ParkingService parkingService;

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping( "/getParkingArea")
    public PageListJSON getParkingAreaByPage(@RequestParam("page") int page , @RequestParam("rows") int rows, @RequestParam(value ="parkingAreaNo",required=false) String parkingAreaNo){

        PageHelper.startPage(page,rows);
        List<ParkingArea> list = parkingService.queryParkingAreaByNo(parkingAreaNo);
        PageInfo pageinfo = new PageInfo(list);

        return new PageListJSON("200",pageinfo.getTotal(),pageinfo.getList());
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping( "/getParkingAreaId")
    public List<Integer> getParkingAreaId(){
        return parkingService.queryParkingAreaId();
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping("/deleteParkingAreas")
    public int deleteParkingAreas(int[] parkingAreaId) {
        return parkingService.deleteParkingAreas(parkingAreaId);
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping("/updateParkingArea")
    public int updateParkingArea(ParkingArea parkingArea){
        return parkingService.updateParkingAreaById(parkingArea);
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping("/addParkingArea")
    public int addParkingArea(ParkingArea parkingArea){
        return parkingService.addParkingArea(parkingArea);
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping("/addParking")
    public int addParking(Parking parking){
        return parkingService.addParking(parking);
    }
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping("/getParkingTotal")
    public int getParkingTotal(){
        return parkingService.queryParkingTotal();
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping("/checkParkingAreaNoIsExist")
    public int checkParkingAreaNoIsExist(ParkingArea parkingArea ) {
        return parkingService.checkParkingAreaNoIsExist(parkingArea);
    }

    //车位
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping( "/getParking")
    public PageListJSON getParkingByPage(@RequestParam("page") int page , @RequestParam("rows") int rows, @RequestParam(value ="parkingNo",required=false) String parkingNo){

        PageHelper.startPage(page,rows);
        List<Map> list = parkingService.queryParkingByNo(parkingNo);
        PageInfo pageinfo = new PageInfo(list);

        return new PageListJSON("200",pageinfo.getTotal(),pageinfo.getList());
    }
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping("/deleteParkings")
    public int deleteParkings(int[] parkId) {
        return parkingService.deleteParkings(parkId);
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping("/checkParkingNoIsExist")
    public int checkParkingNoIsExist(Parking parking) {
        return parkingService.checkParkingNoIsExist(parking);
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping("/updateParking")
    public int updateParking(Parking parking){
        return parkingService.updateParkingById(parking);
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping("/getParkingPie")
    public Map queryParkingPie( ){
        return parkingService.queryParkingPie();
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping( "/getParkingFree")
    public PageListJSON getParkingFree(int page , int rows,String parkingAreaId){

        PageHelper.startPage(page,rows);
        List<Parking> list = parkingService.queryParkingFree(parkingAreaId);
        PageInfo pageinfo = new PageInfo(list);
        return new PageListJSON("200",pageinfo.getTotal(),pageinfo.getList());
    }


    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping("/updateParkingOwnerBind")
    public int updateParkingOwnerBind(String ownerId,String parkId,String month,String type){
        Parking parking = new Parking();
        parking.setOwnerId(ownerId);
        parking.setParkId(Integer.parseInt(parkId));

        if(type.equals("1")){
            Date now = new Date();
            int addMonth = Integer.parseInt(month);
            Calendar curr = Calendar.getInstance();
            curr.set(Calendar.MONTH,curr.get(Calendar.MONTH)+addMonth);
            Date overdue=curr.getTime();

            ParkingRent parkingRent=new ParkingRent();
            parkingRent.setBeginTime(new Timestamp(now.getTime()));
            parkingRent.setOverTime(new Timestamp(overdue.getTime()));
            parkingRent.setOwnerId(ownerId);
            parkingRent.setParkId(Integer.parseInt(parkId));

            parking.setParkStatus("出租");
            if (parkingService.addParkingRent(parkingRent)==1&&parkingService.updateParkingOwnerBind(parking)==1){
                return 1;
            }else{
                return 0;
            }
        }else {
            parking.setParkStatus("已出售");
            return parkingService.updateParkingOwnerBind(parking);
        }
    }

    //进出场信息
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping( "/getParkRecord")
    public PageListJSON getParkRecordByPage(int page , int rows,
                                            @RequestParam(value ="licenseNo",required=false) String licenseNo,
                                            @RequestParam(value ="parkingAreaNo",required=false) String parkingAreaNo){

        PageHelper.startPage(page,rows);
        List<Map> list = parkingService.queryParkRecord(licenseNo,parkingAreaNo);
        PageInfo pageinfo = new PageInfo(list);

        return new PageListJSON("200",pageinfo.getTotal(),pageinfo.getList());
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping("/deleteParkRecord")
    public int deleteParkRecord(String[] parkRecordId) {
        return parkingService.deleteParkRecord(parkRecordId);
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping("/addParkRecord")
    public int addParkRecord(ParkRecord parkRecord){
        return parkingService.addParkRecord(parkRecord);
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping("/leaveParkRecord")
    public int leaveParkRecord(ParkRecord parkRecord){
        return parkingService.updateOutTimeById(parkRecord);
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping( "/getParkingAndOwner")
    public PageListJSON getParkingAndOwnerByPage(int page , int rows,
                                                 @RequestParam(value ="parkingNo",required=false) String parkingNo,
                                                 @RequestParam(value ="ownerName",required=false) String ownerName){
        PageHelper.startPage(page,rows);
        List<Map> list = parkingService.queryParkingAndOwner(parkingNo,ownerName);
        PageInfo pageinfo = new PageInfo(list);
        return new PageListJSON("200",pageinfo.getTotal(),pageinfo.getList());
    }
}
