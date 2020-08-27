package com.lee.community.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;

public class ParkRecord {
    private String parkRecordId;
    private String licenseNo;
    private int parkingAreaId;
    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String inTime;
    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String outTime;

    public ParkRecord() {
    }

    public ParkRecord(String parkRecordId, String licenseNo, int parkingAreaId, String inTime, String outTime) {
        this.parkRecordId = parkRecordId;
        this.licenseNo = licenseNo;
        this.parkingAreaId = parkingAreaId;
        this.inTime = inTime;
        this.outTime = outTime;
    }

    public String getParkRecordId() {
        return parkRecordId;
    }

    public void setParkRecordId(String parkRecordId) {
        this.parkRecordId = parkRecordId;
    }

    public String getLicenseNo() {
        return licenseNo;
    }

    public void setLicenseNo(String licenseNo) {
        this.licenseNo = licenseNo;
    }

    public int getParkingAreaId() {
        return parkingAreaId;
    }

    public void setParkingAreaId(int parkingAreaId) {
        this.parkingAreaId = parkingAreaId;
    }

    public String getInTime() {
        return inTime;
    }

    public void setInTime(String inTime) {
        this.inTime = inTime;
    }

    public String getOutTime() {
        return outTime;
    }

    public void setOutTime(String outTime) {
        this.outTime = outTime;
    }
}
