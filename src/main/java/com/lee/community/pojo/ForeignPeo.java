package com.lee.community.pojo;

public class ForeignPeo {
    private String personNo;
    private String personName;
    private String phone;
    private String reason;
    private String inTime;
    private String outTime;
    private String carLicenes;
    private String carColor;
    private String carType;

    public ForeignPeo() {
    }

    public ForeignPeo(String personNo, String personName, String phone, String reason, String inTime, String outTime, String carLicenes, String carColor, String carType) {
        this.personNo = personNo;
        this.personName = personName;
        this.phone = phone;
        this.reason = reason;
        this.inTime = inTime;
        this.outTime = outTime;
        this.carLicenes = carLicenes;
        this.carColor = carColor;
        this.carType = carType;
    }

    public String getPersonNo() {
        return personNo;
    }

    public void setPersonNo(String personNo) {
        this.personNo = personNo;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
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

    public String getCarLicenes() {
        return carLicenes;
    }

    public void setCarLicenes(String carLicenes) {
        this.carLicenes = carLicenes;
    }

    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }
}
