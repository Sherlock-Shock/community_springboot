package com.lee.community.pojo;

public class ParkingArea {
    private int parkingAreaId;
    private String parkingAreaNo;
    private String parkingType;
    private String parkAddress;

    public ParkingArea() {
    }

    public ParkingArea(int parkingAreaId, String parkingAreaNo, String parkingType, String parkAddress) {
        this.parkingAreaId = parkingAreaId;
        this.parkingAreaNo = parkingAreaNo;
        this.parkingType = parkingType;
        this.parkAddress = parkAddress;
    }

    public int getParkingAreaId() {
        return parkingAreaId;
    }

    public void setParkingAreaId(int parkingAreaId) {
        this.parkingAreaId = parkingAreaId;
    }

    public String getParkingAreaNo() {
        return parkingAreaNo;
    }

    public void setParkingAreaNo(String parkingAreaNo) {
        this.parkingAreaNo = parkingAreaNo;
    }

    public String getParkingType() {
        return parkingType;
    }

    public void setParkingType(String parkingType) {
        this.parkingType = parkingType;
    }

    public String getParkAddress() {
        return parkAddress;
    }

    public void setParkAddress(String parkAddress) {
        this.parkAddress = parkAddress;
    }

    @Override
    public String toString() {
        return "ParkingArea{" +
                "parkingAreaId=" + parkingAreaId +
                ", parkingAreaNo='" + parkingAreaNo + '\'' +
                ", parkingType='" + parkingType + '\'' +
                ", parkAddress='" + parkAddress + '\'' +
                '}';
    }
}
