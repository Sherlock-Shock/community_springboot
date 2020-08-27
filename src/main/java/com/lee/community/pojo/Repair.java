package com.lee.community.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Timestamp;

public class Repair {
    private String repairNo;
    private String ownerId;
    private Timestamp rtime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp appTime;
    private String roomNo;
    private String reason;
    private String phone;
    private String status;

    public Repair() {
    }

    public Repair(String repairNo, String ownerId, Timestamp rtime, Timestamp appTime, String roomNo, String reason, String phone, String status) {
        this.repairNo = repairNo;
        this.ownerId = ownerId;
        this.rtime = rtime;
        this.appTime = appTime;
        this.roomNo = roomNo;
        this.reason = reason;
        this.phone = phone;
        this.status = status;
    }

    public String getRepairNo() {
        return repairNo;
    }

    public void setRepairNo(String repairNo) {
        this.repairNo = repairNo;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public Timestamp getRtime() {
        return rtime;
    }

    public void setRtime(Timestamp rtime) {
        this.rtime = rtime;
    }

    public Timestamp getAppTime() {
        return appTime;
    }

    public void setAppTime(Timestamp appTime) {
        this.appTime = appTime;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
