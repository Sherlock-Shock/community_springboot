package com.lee.community.mapper;

import com.lee.community.pojo.Bhouse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface BhouseMapper {
    List<Map> queryHouse(Bhouse bhouse);
    int deleteHouses(int[] hids);
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
