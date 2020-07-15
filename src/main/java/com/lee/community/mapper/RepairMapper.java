package com.lee.community.mapper;

import com.lee.community.pojo.Repair;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface RepairMapper {
    List<Map> queryRepair(@Param("ownerName") String ownerName,
                          @Param("phone") String phone,
                          @Param("status") String status);
    int updateRepairById(Repair repair);
    int addRepair(Repair repair);
    int updateStatusByNo(@Param("status") String status,
                     @Param("repairNo") String repairNo);
    Map queryRepairDetail(String repairNo);
    List<Map> queryRepairByOwnerId(String ownerId);
    int deleteRepairByNos(String[] Nos);
}
