package com.lee.community.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lee.community.dto.PageListJSON;
import com.lee.community.dto.ResultJSON;
import com.lee.community.pojo.Repair;
import com.lee.community.pojo.Repaired;
import com.lee.community.service.RepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class RepairController {
    @Autowired
    RepairService repairService;

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping("/getRepairList")
    public PageListJSON getRepairByPage(int page , int rows,
                                        @RequestParam(value ="ownerName",required=false) String ownerName,
                                        @RequestParam(value ="phone",required=false) String phone,
                                        @RequestParam(value ="status",required=false) String status){
        PageHelper.startPage(page,rows);
        List<Map> list = repairService.queryRepair(ownerName,phone,status);
        PageInfo pageinfo = new PageInfo(list);
        return new PageListJSON("200",pageinfo.getTotal(),pageinfo.getList());
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping("/updateRepair")
    public int updateRepair(Repair repair){
        return repairService.updateRepairById(repair);
    }

    @PostMapping("/addRepair")
    public int addRepair(Repair repair){
        return repairService.addRepair(repair);
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping("/deleteRepairs")
    public int deleteRepairs(String[] RepairNo) {
        return repairService.deleteRepairByNos(RepairNo);
    }


    @PostMapping("/getRepairListByOwnerId")
    public PageListJSON getRepairListByOwnerId(int page , int rows,String ownerId){
        PageHelper.startPage(page,rows);
        List<Map> list = repairService.queryRepairByOwnerId(ownerId);
        PageInfo pageinfo = new PageInfo(list);
        return new PageListJSON("200",pageinfo.getTotal(),pageinfo.getList());
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping("/addRepaired")
    public int addRepaired(Repaired repaired){
        return repairService.addRepaired(repaired);
    }


    @PostMapping("/getRepairDetail")
    public ResultJSON getRepairDetail(String repairNo){
        return new ResultJSON("200","",repairService.queryRepairDetail(repairNo));
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping("/getRepairOne")
    public ResultJSON getRepairOne(String repairNo){
        return new ResultJSON("200","",repairService.queryRepairedOne(repairNo));
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping("/finishRepair")
    public int finishRepair(Repaired repaired){
        return repairService.updateRepairFinish(repaired);
    }

}
