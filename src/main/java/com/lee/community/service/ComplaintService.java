package com.lee.community.service;

import com.lee.community.pojo.Complaint;

import java.util.List;

public interface ComplaintService {
    List<Complaint> queryComplaint(Complaint complaint);
    int updateComplaintById(Complaint complaint);
    int deleteComplaint(String[] ids);
    int addComplaint(Complaint complaint);
    int reviewComplaint(Complaint complaint);
}
