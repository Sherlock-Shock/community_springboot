package com.lee.community.serviceimpl;

import com.lee.community.mapper.ComplaintMapper;
import com.lee.community.pojo.Complaint;
import com.lee.community.service.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
public class ComplaintServiceImpl implements ComplaintService {
    @Autowired
    ComplaintMapper complaintMapper;

    @Override
    public List<Complaint> queryComplaint(Complaint complaint) {
        return complaintMapper.queryComplaint(complaint);
    }

    @Override
    public int updateComplaintById(Complaint complaint) {
        return complaintMapper.updateComplaintById(complaint);
    }

    @Override
    public int deleteComplaint(String[] ids) {
        return complaintMapper.deleteComplaint(ids);
    }

    @Override
    public int addComplaint(Complaint complaint) {
        complaint.setComplaintId("1000"+String.valueOf(new Date().getTime()));
        complaint.setComTime(new Timestamp(new Date().getTime()));
        complaint.setStatus(0);
        return complaintMapper.addComplaint(complaint);
    }

    @Override
    public int reviewComplaint(Complaint complaint) {
        complaint.setFinishTime(new Timestamp(new Date().getTime()));
        return complaintMapper.reviewComplaint(complaint);
    }
}
