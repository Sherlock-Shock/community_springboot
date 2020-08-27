package com.lee.community.pojo;

import java.sql.Timestamp;

public class ParkingRent {
    private int rentId;
    private int parkId;
    private String ownerId;
    private Timestamp beginTime;
    private Timestamp overTime;
    private int delFlag;

    public ParkingRent() {
    }

    public ParkingRent(int rentId, int parkId, String ownerId, Timestamp beginTime, Timestamp overTime, int delFlag) {
        this.rentId = rentId;
        this.parkId = parkId;
        this.ownerId = ownerId;
        this.beginTime = beginTime;
        this.overTime = overTime;
        this.delFlag = delFlag;
    }

    public int getRentId() {
        return rentId;
    }

    public void setRentId(int rentId) {
        this.rentId = rentId;
    }

    public int getParkId() {
        return parkId;
    }

    public void setParkId(int parkId) {
        this.parkId = parkId;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public Timestamp getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Timestamp beginTime) {
        this.beginTime = beginTime;
    }

    public Timestamp getOverTime() {
        return overTime;
    }

    public void setOverTime(Timestamp overTime) {
        this.overTime = overTime;
    }

    public int getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(int delFlag) {
        this.delFlag = delFlag;
    }
}
