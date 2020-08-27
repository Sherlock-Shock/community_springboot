package com.lee.community.pojo;

public class Parking {
    private int parkId;
    private String ownerId;
    private int parkingAreaId;
    private String parkingNo;
    private String parkStatus;
    private String parkingAreal;

    public Parking() {
    }

    public Parking(int parkId, String ownerId, int parkingAreaId, String parkingNo, String parkStatus, String parkingAreal) {
        this.parkId = parkId;
        this.ownerId = ownerId;
        this.parkingAreaId = parkingAreaId;
        this.parkingNo = parkingNo;
        this.parkStatus = parkStatus;
        this.parkingAreal = parkingAreal;
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

    public int getParkingAreaId() {
        return parkingAreaId;
    }

    public void setParkingAreaId(int parkingAreaId) {
        this.parkingAreaId = parkingAreaId;
    }

    public String getParkingNo() {
        return parkingNo;
    }

    public void setParkingNo(String parkingNo) {
        this.parkingNo = parkingNo;
    }

    public String getParkStatus() {
        return parkStatus;
    }

    public void setParkStatus(String parkStatus) {
        this.parkStatus = parkStatus;
    }

    public String getParkingAreal() {
        return parkingAreal;
    }

    public void setParkingAreal(String parkingAreal) {
        this.parkingAreal = parkingAreal;
    }
}
