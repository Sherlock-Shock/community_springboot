package com.lee.community.serviceimpl;

import com.lee.community.mapper.RepairMapper;
import com.lee.community.mapper.RepairedMapper;
import com.lee.community.pojo.Repair;
import com.lee.community.pojo.Repaired;
import com.lee.community.service.RepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class RepairServiceImpl implements RepairService {
    @Autowired
    RepairMapper repairMapper;
    @Autowired
    RepairedMapper repairedMapper;

    @Override
    public List<Map> queryRepair(String ownerName,String phone,String status) {
        return repairMapper.queryRepair(ownerName,phone,status);
    }

    @Override
    public int updateRepairById(Repair repair) {
        return repairMapper.updateRepairById(repair);
    }

    @Override
    public int addRepair(Repair repair) {
        repair.setRepairNo("1100"+String.valueOf(System.currentTimeMillis()));
        repair.setRtime(new Timestamp(System.currentTimeMillis()));
        repair.setStatus("0");
        return repairMapper.addRepair(repair);
    }

    @Override
    public int deleteRepairByNos(String[] Nos) {
        return repairMapper.deleteRepairByNos(Nos);
    }

    @Override
    public Map queryRepairDetail(String repairNo) {
        return repairMapper.queryRepairDetail(repairNo);
    }

    @Override
    public Repaired queryRepairedOne(String repairNo) {
        return repairedMapper.queryRepairedOne(repairNo);
    }

    @Override
    public int addRepaired(Repaired repaired) {
        repaired.setRepairedNo("1100"+String.valueOf(new Date().getTime()));
        repairMapper.updateStatusByNo("1",repaired.getRepairNo());
        return repairedMapper.addRepaired(repaired);
    }

    @Override
    public int updateRepairFinish(Repaired repaired) {
        repairMapper.updateStatusByNo("2",repaired.getRepairNo());
        repaired.setFinishTime(new Timestamp(new Date().getTime()));
        return repairedMapper.updateRepairFinish(repaired);
    }

    @Override
    public List<Map> queryRepairByOwnerId(String ownerId) {
        return repairMapper.queryRepairByOwnerId(ownerId);
    }
}
