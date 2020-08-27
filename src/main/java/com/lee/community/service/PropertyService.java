package com.lee.community.service;

import com.lee.community.pojo.Bbuilding;
import com.lee.community.pojo.Bhouse;
import com.lee.community.pojo.Bunit;

import java.util.List;
import java.util.Map;

public interface PropertyService {
    //building
    List<Bbuilding> queryBuildingByPage(int page,int pagesize);
    List<Bbuilding> queryAllBuildings();
    int addbuilding(Bbuilding bbuilding);
    int deleteBuildingById(int bulidingId);
    int deleteBuildings(int[] bulidingIds);
    List<Bbuilding> queryAllBuildingByNo(int bulidingNo);
    int updateBuildingById(Bbuilding bbuilding);
    int checkBuildingNoIsExist(Bbuilding bbuilding);

    //unit
    int addUnit(Bunit bunit);
    List<Map> queryBunitByNo(Integer unitNo);
    int deleteUnits(int[] unitId);
    int updateUnitById(Bunit bunit);
    int checkUnitNoIsExist(Bunit bunit);

    //house
    List<Map> queryHouse(Bhouse bhouse);
    int deleteHouses(int[] hids);
    List<Integer> queryBuildingNo();
    List<Integer> queryUnitNo();
    List<Bbuilding> queryBuildingNoAndUnitNo();
    int addHouse(Bhouse bhouse);
    int updateHouseById(Bhouse bhouse);
    int updateHouseOwnerById(Bhouse bhouse);
    List<Map> queryHouseAndOwner(Bhouse bhouse);
    int queryHouseTotal();
    List<Bhouse> queryOwnerAllHouse(String ownerId);
    int  updateHouseOwnerDrop(String houseId);
    int checkRoomNoIsExist(Bhouse bhouse);
    Map queryHousePie();
}
