package com.lee.community.pojo;

public class Bunit {
    private int unitId;
    private int buildingId;
    private String unitNo;
    private int floor;
    private String lift;

    public Bunit() {
    }

    public Bunit(int unitId, int buildingId, String unitNo, int floor, String lift) {
        this.unitId = unitId;
        this.buildingId = buildingId;
        this.unitNo = unitNo;
        this.floor = floor;
        this.lift = lift;
    }

    public int getUnitId() {
        return unitId;
    }

    public void setUnitId(int unitId) {
        this.unitId = unitId;
    }

    public int getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(int buildingId) {
        this.buildingId = buildingId;
    }

    public String getUnitNo() {
        return unitNo;
    }

    public void setUnitNo(String unitNo) {
        this.unitNo = unitNo;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public String getLift() {
        return lift;
    }

    public void setLift(String lift) {
        this.lift = lift;
    }

    @Override
    public String toString() {
        return "Bunit{" +
                "unitId=" + unitId +
                ", buildingId=" + buildingId +
                ", unitNo='" + unitNo + '\'' +
                ", floor=" + floor +
                ", lift='" + lift + '\'' +
                '}';
    }
}
