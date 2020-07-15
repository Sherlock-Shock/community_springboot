package com.lee.community.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lee.community.dto.PageListJSON;
import com.lee.community.pojo.Complaint;
import com.lee.community.service.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ComplaintController {
    @Autowired
    ComplaintService complaintService;

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping( "/getComplaint")
    public PageListJSON getComplaintByPage(int page , int rows, Complaint complaint){
        System.out.println("接收的status："+complaint.getStatus());
        PageHelper.startPage(page,rows);
        List<Complaint> list = complaintService.queryComplaint(complaint);
        PageInfo pageinfo = new PageInfo(list);
        return new PageListJSON("200",pageinfo.getTotal(),pageinfo.getList());
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping( "/updateComplaint")
    public int updateComplaint(Complaint complaint){
        return complaintService.updateComplaintById(complaint);
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping( "/deleteComplaint")
    public int deleteComplaint(String[] complaintId){
        return complaintService.deleteComplaint(complaintId);
    }

    @PostMapping( "/addComplaint")
    public int addComplaint(Complaint complaint){
        return complaintService.addComplaint(complaint);
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping( "/reviewComplaint")
    public int reviewComplaint(Complaint complaint){
        return complaintService.reviewComplaint(complaint);
    }

}
