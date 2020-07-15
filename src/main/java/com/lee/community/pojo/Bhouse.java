package com.lee.community.pojo;

public class Bhouse {
    private int houseId;
    private String ownerId;
    private String houseStatus;
    private String houseAreal;
    private String bulidingNo;
    private String unitNo;
    private String roomNo;
    private int rate;

    public Bhouse() {
    }

    public Bhouse(int houseId) {
        this.houseId = houseId;
    }

    public Bhouse(int houseId, String ownerId, String houseStatus, String houseAreal, String bulidingNo, String unitNo, String roomNo, int rate) {
        this.houseId = houseId;
        this.ownerId = ownerId;
        this.houseStatus = houseStatus;
        this.houseAreal = houseAreal;
        this.bulidingNo = bulidingNo;
        this.unitNo = unitNo;
        this.roomNo = roomNo;
        this.rate = rate;
    }

    public int getHouseId() {
        return houseId;
    }


    public void setHouseId(int houseId) {
        this.houseId = houseId;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getHouseStatus() {
        return houseStatus;
    }

    public void setHouseStatus(String houseStatus) {
        this.houseStatus = houseStatus;
    }

    public String getHouseAreal() {
        return houseAreal;
    }

    public void setHouseAreal(String houseAreal) {
        this.houseAreal = houseAreal;
    }

    public String getBulidingNo() {
        return bulidingNo;
    }

    public void setBulidingNo(String bulidingNo) {
        this.bulidingNo = bulidingNo;
    }

    public String getUnitNo() {
        return unitNo;
    }

    public void setUnitNo(String unitNo) {
        this.unitNo = unitNo;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "Bhouse{" +
                "houseId=" + houseId +
                ", ownerId='" + ownerId + '\'' +
                ", houseStatus='" + houseStatus + '\'' +
                ", houseAreal='" + houseAreal + '\'' +
                ", bulidingNo='" + bulidingNo + '\'' +
                ", unitNo='" + unitNo + '\'' +
                ", roomNo='" + roomNo + '\'' +
                ", rate=" + rate +
                '}';
    }
}
