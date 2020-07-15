package com.lee.community.pojo;

import java.sql.Timestamp;

public class PaymentList {
    private String paymentId;
    private String payPerId;
    private String payItemId;
    private String receiver;
    private Timestamp payTime;
    private String payable;
    private String factPay;
    private int houseId;
    private int parkId;

    public PaymentList(String paymentId, String payPerId, String payItemId, String receiver, Timestamp payTime, String payable, String factPay) {
        this.paymentId = paymentId;
        this.payPerId = payPerId;
        this.payItemId = payItemId;
        this.receiver = receiver;
        this.payTime = payTime;
        this.payable = payable;
        this.factPay = factPay;
    }

    public PaymentList() {
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getPayPerId() {
        return payPerId;
    }

    public void setPayPerId(String payPerId) {
        this.payPerId = payPerId;
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

    public String getFactPay() {
        return factPay;
    }

    public void setFactPay(String factPay) {
        this.factPay = factPay;
    }

    public int getHouseId() {
        return houseId;
    }

    public void setHouseId(int houseId) {
        this.houseId = houseId;
    }

    public int getParkId() {
        return parkId;
    }

    public void setParkId(int parkId) {
        this.parkId = parkId;
    }
}
