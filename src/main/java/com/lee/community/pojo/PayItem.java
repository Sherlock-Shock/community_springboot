package com.lee.community.pojo;

public class PayItem {
    private String payItemId;
    private String payItemType;
    private String payItemName;
    private String payItemPeriod;
    private String beginTime;
    private String overTime;
    private String charStandard;
    private String charOnce;

    public PayItem() {
    }

    public PayItem(String payItemId, String payItemType, String payItemName, String payItemPeriod, String beginTime, String overTime, String charStandard, String charOnce) {
        this.payItemId = payItemId;
        this.payItemType = payItemType;
        this.payItemName = payItemName;
        this.payItemPeriod = payItemPeriod;
        this.beginTime = beginTime;
        this.overTime = overTime;
        this.charStandard = charStandard;
        this.charOnce = charOnce;
    }

    public String getPayItemId() {
        return payItemId;
    }

    public void setPayItemId(String payItemId) {
        this.payItemId = payItemId;
    }

    public String getPayItemType() {
        return payItemType;
    }

    public void setPayItemType(String payItemType) {
        this.payItemType = payItemType;
    }

    public String getPayItemName() {
        return payItemName;
    }

    public void setPayItemName(String payItemName) {
        this.payItemName = payItemName;
    }

    public String getPayItemPeriod() {
        return payItemPeriod;
    }

    public void setPayItemPeriod(String payItemPeriod) {
        this.payItemPeriod = payItemPeriod;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getOverTime() {
        return overTime;
    }

    public void setOverTime(String overTime) {
        this.overTime = overTime;
    }

    public String getCharStandard() {
        return charStandard;
    }

    public void setCharStandard(String charStandard) {
        this.charStandard = charStandard;
    }

    public String getCharOnce() {
        return charOnce;
    }

    public void setCharOnce(String charOnce) {
        this.charOnce = charOnce;
    }
}
