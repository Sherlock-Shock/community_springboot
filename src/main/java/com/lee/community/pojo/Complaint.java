package com.lee.community.pojo;

import java.sql.Timestamp;

public class Complaint {
    private String complaintId;
    private String complainter;
    private String roomNo;
    private Timestamp comTime;
    private String comContent;
    private String comPhone;
    private String receiver;
    private String result;
    private int status;
    private Timestamp finishTime;

    public Complaint() {
    }

    public Complaint(String complaintId, String complainter, String roomNo, Timestamp comTime, String comContent, String comPhone, String receiver, String result, int status, Timestamp finishTime) {
        this.complaintId = complaintId;
        this.complainter = complainter;
        this.roomNo = roomNo;
        this.comTime = comTime;
        this.comContent = comContent;
        this.comPhone = comPhone;
        this.receiver = receiver;
        this.result = result;
        this.status = status;
        this.finishTime = finishTime;
    }

    public String getComplaintId() {
        return complaintId;
    }

    public void setComplaintId(String complaintId) {
        this.complaintId = complaintId;
    }

    public String getComplainter() {
        return complainter;
    }

    public void setComplainter(String complainter) {
        this.complainter = complainter;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public Timestamp getComTime() {
        return comTime;
    }

    public void setComTime(Timestamp comTime) {
        this.comTime = comTime;
    }

    public String getComContent() {
        return comContent;
    }

    public void setComContent(String comContent) {
        this.comContent = comContent;
    }

    public String getComPhone() {
        return comPhone;
    }

    public void setComPhone(String comPhone) {
        this.comPhone = comPhone;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Timestamp getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Timestamp finishTime) {
        this.finishTime = finishTime;
    }
}
