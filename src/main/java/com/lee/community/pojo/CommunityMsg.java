package com.lee.community.pojo;

public class CommunityMsg {
    private int communityId;
    private String cname;
    private String summary;
    private String company;
    private String address;
    private String landmark;
    private String tell;

    public CommunityMsg() {
    }

    public CommunityMsg(int communityId, String cname, String summary, String company, String address, String landmark, String tell) {
        this.communityId = communityId;
        this.cname = cname;
        this.summary = summary;
        this.company = company;
        this.address = address;
        this.landmark = landmark;
        this.tell = tell;
    }

    public int getCommunityId() {
        return communityId;
    }

    public void setCommunityId(int communityId) {
        this.communityId = communityId;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLandmark() {
        return landmark;
    }

    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }

    public String getTell() {
        return tell;
    }

    public void setTell(String tell) {
        this.tell = tell;
    }
}
