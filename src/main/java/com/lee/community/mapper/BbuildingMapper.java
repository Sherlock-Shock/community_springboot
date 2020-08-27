package com.lee.community.mapper;

import com.lee.community.pojo.Bbuilding;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BbuildingMapper {
    List<Bbuilding> queryAllBuilding();
    int addbuilding(Bbuilding bbuilding);
    int deleteBuildingById(int bulidingId);
    int deleteBuildings(int[] bulidingIds);
    List<Bbuilding> queryAllBuildingByNo(int bulidingNo);
    int updateBuildingById(Bbuilding bbuilding);
    List<Integer> queryBuildingNo();
    List<Bbuilding> queryBuildingNoAndUnitNo();
    int checkBuildingNoIsExist(Bbuilding bbuilding);
}
