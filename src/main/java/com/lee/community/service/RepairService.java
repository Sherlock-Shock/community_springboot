package com.lee.community.service;

import com.lee.community.pojo.Repair;
import com.lee.community.pojo.Repaired;

import java.util.List;
import java.util.Map;

public interface RepairService {
    List<Map> queryRepair(String ownerName, String phone, String status);
    int updateRepairById(Repair repair);
    int addRepair(Repair repair);
    Map queryRepairDetail(String repairNo);
    Repaired queryRepairedOne(String repairNo);
    List<Map> queryRepairByOwnerId(String ownerId);
    int deleteRepairByNos(String[] Nos);

    int addRepaired(Repaired repaired);
    int updateRepairFinish(Repaired repaired);
}
