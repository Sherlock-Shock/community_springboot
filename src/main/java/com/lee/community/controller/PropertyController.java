package com.lee.community.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lee.community.dto.PageListJSON;
import com.lee.community.dto.ResultJSON;
import com.lee.community.pojo.Bbuilding;
import com.lee.community.pojo.Bhouse;
import com.lee.community.pojo.Bunit;
import com.lee.community.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class PropertyController {

    @Autowired
    PropertyService propertyService;

    //building
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @RequestMapping( value = "/getBuildings", method = RequestMethod.GET )
    public PageListJSON getBuildingsByPage(@RequestParam("page") int page , @RequestParam("rows") int rows){
        PageHelper.startPage(page,rows);
        List<Bbuilding> list = propertyService.queryAllBuildings();
        PageInfo pageinfo = new PageInfo(list);

        return new PageListJSON("200",pageinfo.getTotal(),pageinfo.getList());
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping("/addbuilding")
    public int addbuilding(Bbuilding bbuilding){
        System.out.println("bbbbb："+bbuilding.getBulidingno()+"---"+bbuilding.getBulidingname());
        return propertyService.addbuilding(bbuilding);
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping("/deleteBuilding")
    public int deleteBuilding(int bbuildingId){
        return propertyService.deleteBuildingById(bbuildingId);
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping("/deleteBuildings")
    public int deleteBuildings(int[] bbuildingIds){

        return propertyService.deleteBuildings(bbuildingIds);
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @RequestMapping( value = "/getBuildingsByNo", method = RequestMethod.GET )
    public PageListJSON getBuildingsByNo(@RequestParam("page") int page , @RequestParam("rows") int rows,@RequestParam("buildingNo") int buildingNo){

        //System.out.println("接收的page、rows：:"+page+"---"+rows);
        PageHelper.startPage(page,rows);
        List<Bbuilding> list = propertyService.queryAllBuildingByNo(buildingNo);
        PageInfo pageinfo = new PageInfo(list);
        System.out.println(pageinfo.getTotal());
        return new PageListJSON("200",pageinfo.getTotal(),pageinfo.getList());
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping("/updateBuilding")
    public int updateBuilding(Bbuilding bbuilding){
        return propertyService.updateBuildingById(bbuilding);
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping("/checkBuildingNoIsExist")
    public int checkBuildingNoIsExist(Bbuilding bbuilding){
        return propertyService.checkBuildingNoIsExist(bbuilding);
    }

    //unit
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping("/addunit")
    public int addunit(Bunit bunit){
        System.out.println(bunit);
        return propertyService.addUnit(bunit);
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @RequestMapping( value = "/getUnits", method = RequestMethod.GET )
    public PageListJSON getUnitsByPage(@RequestParam("page") int page , @RequestParam("rows") int rows,@RequestParam(value ="unitNo",required=false) Integer unitNo){

        //System.out.println("接收的page、rows：:"+page+"---"+rows);
        PageHelper.startPage(page,rows);
        List<Map> list = propertyService.queryBunitByNo(unitNo);
        PageInfo pageinfo = new PageInfo(list);

        return new PageListJSON("200",pageinfo.getTotal(),pageinfo.getList());
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping("/deleteUnits")
    public int deleteUnits(int[] unitId){
        return propertyService.deleteUnits(unitId);
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping("/updateUnit")
    public int updateUnit(Bunit bunit){
        return propertyService.updateUnitById(bunit);
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping("/checkUnitNoIsExist")
    public int checkUnitNoIsExist(int buildingId,String unitNo ){
        Bunit bunit = new Bunit();
        bunit.setBuildingId(buildingId);
        bunit.setUnitNo(unitNo);
        return propertyService.checkUnitNoIsExist(bunit);
    }

    //house
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @RequestMapping( value = "/getHouse", method = RequestMethod.POST )
    public PageListJSON getHouseByPage(int page , int rows,Bhouse house){
        //System.out.println("接收的house:"+house);
        //System.out.println("接收的page、rows：:"+page+"---"+rows);
        PageHelper.startPage(page,rows);
        List<Map> list = propertyService.queryHouse(house);
        PageInfo pageinfo = new PageInfo(list);

        return new PageListJSON("200",pageinfo.getTotal(),pageinfo.getList());
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping("/deleteHouses")
    public int deleteHouses(int[] houseId){
        return propertyService.deleteHouses(houseId);
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/getBuildingNo")
    public List<Integer> getBuildingNo(){
        return propertyService.queryBuildingNo();
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/getUnitNo")
    public List<Integer> getUnitNo(){
        return propertyService.queryUnitNo();
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/getBUNo")
    public List<Bbuilding> getBuildingNoAndUnitNo(){
        return propertyService.queryBuildingNoAndUnitNo();
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping("/addHouse")
    public int addHouse(Bhouse bhouse){
        return propertyService.addHouse(bhouse);
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping("/getHouseTotal")
    public int getHouseTotal(){
        return propertyService.queryHouseTotal();
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping("/updateHouse")
    public int updateHouse(Bhouse bhouse){
        System.out.println("修改接收的"+bhouse);
        return propertyService.updateHouseById(bhouse);
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping("/updateHouseOwner")
    public int updateHouseOwner(Bhouse bhouse){
        return propertyService.updateHouseOwnerById(bhouse);
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping( "/getHouseAndOwner")
    public PageListJSON getHouseAndOwnerByPage(int page , int rows,Bhouse house){
        PageHelper.startPage(page,rows);
        List<Map> list = propertyService.queryHouseAndOwner(house);
        PageInfo pageinfo = new PageInfo(list);
        return new PageListJSON("200",pageinfo.getTotal(),pageinfo.getList());
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping("/checkRoomNoIsExist")
    public int checkRoomNoIsExist(String bulidingNo,String unitNo,String roomNo){
        Bhouse bhouse = new Bhouse();
        bhouse.setBulidingNo(bulidingNo);
        bhouse.setUnitNo(unitNo);
        bhouse.setRoomNo(roomNo);
        return propertyService.checkRoomNoIsExist(bhouse);
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping("/getHousePie")
    public Map queryHousePie( ){
        return propertyService.queryHousePie();
    }
}
