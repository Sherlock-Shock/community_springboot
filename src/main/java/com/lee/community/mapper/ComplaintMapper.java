package com.lee.community.mapper;

import com.lee.community.pojo.Complaint;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ComplaintMapper {
    List<Complaint> queryComplaint(Complaint complaint);
    int updateComplaintById(Complaint complaint);
    int deleteComplaint(String[] ids);
    int addComplaint(Complaint complaint);
    int reviewComplaint(Complaint complaint);
}
