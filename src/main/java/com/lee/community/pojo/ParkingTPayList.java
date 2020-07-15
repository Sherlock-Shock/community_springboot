package com.lee.community.pojo;

import java.sql.Timestamp;

public class ParkingTPayList {
    private String paymentId;
    private String parkRecordId;
    private String payItemId;
    private String receiver;
    private Timestamp payTime;
    private String payable;

    public ParkingTPayList() {
    }

    public ParkingTPayList(String paymentId, String parkRecordId, String payItemId, String receiver, Timestamp payTime, String payable) {
        this.paymentId = paymentId;
        this.parkRecordId = parkRecordId;
        this.payItemId = payItemId;
        this.receiver = receiver;
        this.payTime = payTime;
        this.payable = payable;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getParkRecordId() {
        return parkRecordId;
    }

    public void setParkRecordId(String parkRecordId) {
        this.parkRecordId = parkRecordId;
    }

    public String getPayItemId() {
        return payItemId;
    }

    public void setPayItemId(String payItemId) {
        this.payItemId = payItemId;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public Timestamp getPayTime() {
        return payTime;
    }

    public void setPayTime(Timestamp payTime) {
        this.payTime = payTime;
    }

    public String getPayable() {
        return payable;
    }

    public void setPayable(String payable) {
        this.payable = payable;
    }
}
