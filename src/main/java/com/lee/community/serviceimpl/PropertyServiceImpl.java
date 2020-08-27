package com.lee.community.serviceimpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lee.community.mapper.BbuildingMapper;
import com.lee.community.mapper.BhouseMapper;
import com.lee.community.mapper.BunitMapper;
import com.lee.community.pojo.Bbuilding;
import com.lee.community.pojo.Bhouse;
import com.lee.community.pojo.Bunit;
import com.lee.community.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PropertyServiceImpl implements PropertyService {

    @Autowired
    BbuildingMapper bbuildingMapper;
    @Autowired
    BunitMapper bunitMapper;
    @Autowired
    BhouseMapper bhouseMapper;


    //building
    @Override
    public List<Bbuilding> queryBuildingByPage(int page, int pagesize) {

        PageHelper.startPage(page,pagesize);
        List<Bbuilding> bbuildings = bbuildingMapper.queryAllBuilding();
        PageInfo pageInfo=new PageInfo(bbuildings);

        return pageInfo.getList();
    }

    @Override
    public List<Bbuilding> queryAllBuildings() {
        return bbuildingMapper.queryAllBuilding();
    }

    @Override
    public int addbuilding(Bbuilding bbuilding) {
        return bbuildingMapper.addbuilding( bbuilding);
    }

    @Override
    public int deleteBuildingById(int bulidingId) {
        return bbuildingMapper.deleteBuildingById(bulidingId);
    }

    @Override
    public int deleteBuildings(int[] bulidingIds) {
        return bbuildingMapper.deleteBuildings(bulidingIds);
    }

    @Override
    public List<Bbuilding> queryAllBuildingByNo(int bulidingNo) {
        return bbuildingMapper.queryAllBuildingByNo(bulidingNo);
    }

    @Override
    public int updateBuildingById(Bbuilding bbuilding) {
        return bbuildingMapper.updateBuildingById(bbuilding);
    }

    @Override
    public int checkBuildingNoIsExist(Bbuilding bbuilding) {
        return bbuildingMapper.checkBuildingNoIsExist(bbuilding);
    }
    //unit

    @Override
    public int addUnit(Bunit bunit) {
        return bunitMapper.addUnit(bunit);
    }

    @Override
    public List<Map> queryBunitByNo(Integer unitNo) {
        return bunitMapper.queryBunitByNo(unitNo);
    }

    @Override
    public int deleteUnits(int[] unitId) {
        return bunitMapper.deleteUnits(unitId);
    }

    @Override
    public int updateUnitById(Bunit bunit) {
        return bunitMapper.updateUnitById(bunit);
    }

    @Override
    public int checkUnitNoIsExist(Bunit bunit) {
        return bunitMapper.checkUnitNoIsExist(bunit);
    }
    //house

    @Override
    public List<Map> queryHouse(Bhouse bhouse) {
        return bhouseMapper.queryHouse(bhouse);
    }

    @Override
    public int deleteHouses(int[] hids){
        return  bhouseMapper.deleteHouses(hids);
    }

    @Override
    public List<Integer> queryBuildingNo() {
        return bbuildingMapper.queryBuildingNo();
    }

    @Override
    public List<Integer> queryUnitNo() {
        return bunitMapper.queryUnitNo();
    }

    @Override
    public List<Bbuilding> queryBuildingNoAndUnitNo() {
        return bbuildingMapper.queryBuildingNoAndUnitNo();
    }

    @Override
    public int addHouse(Bhouse bhouse) {
        return bhouseMapper.addHouse(bhouse);
    }

    @Override
    public int updateHouseById(Bhouse bhouse) {
        return bhouseMapper.updateHouseById(bhouse);
    }

    @Override
    public int updateHouseOwnerById(Bhouse bhouse) {
        return bhouseMapper.updateHouseOwnerById(bhouse);
    }

    @Override
    public List<Map> queryHouseAndOwner(Bhouse bhouse) {
        return bhouseMapper.queryHouseAndOwner(bhouse);
    }

    @Override
    public int queryHouseTotal() {
        return bhouseMapper.queryHouseTotal();
    }

    @Override
    public List<Bhouse> queryOwnerAllHouse(String ownerId) {
        return bhouseMapper.queryOwnerAllHouse(ownerId);
    }

    @Override
    public int updateHouseOwnerDrop(String houseId) {
        return bhouseMapper.updateHouseOwnerDrop(houseId);
    }

    @Override
    public int checkRoomNoIsExist(Bhouse bhouse) {
        return bhouseMapper.checkRoomNoIsExist(bhouse);
    }

    @Override
    public Map queryHousePie() {
        return bhouseMapper.queryHousePie();
    }
}
