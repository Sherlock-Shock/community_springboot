package com.lee.community.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Timestamp;

public class Repaired {
    private String repairedNo;
    private String repairNo;
    private Timestamp finishTime;
    private String workerName;
    private String workerPhone;
    private String mark;

    public Repaired() {
    }

    public Repaired(String repairedNo, String repairNo, Timestamp finishTime, String workerName, String workerPhone, String mark) {
        this.repairedNo = repairedNo;
        this.repairNo = repairNo;
        this.finishTime = finishTime;
        this.workerName = workerName;
        this.workerPhone = workerPhone;
        this.mark = mark;
    }

    public String getRepairedNo() {
        return repairedNo;
    }

    public void setRepairedNo(String repairedNo) {
        this.repairedNo = repairedNo;
    }

    public String getRepairNo() {
        return repairNo;
    }

    public void setRepairNo(String repairNo) {
        this.repairNo = repairNo;
    }

    public Timestamp getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Timestamp finishTime) {
        this.finishTime = finishTime;
    }

    public String getWorkerName() {
        return workerName;
    }

    public void setWorkerName(String workerName) {
        this.workerName = workerName;
    }

    public String getWorkerPhone() {
        return workerPhone;
    }

    public void setWorkerPhone(String workerPhone) {
        this.workerPhone = workerPhone;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }
}
