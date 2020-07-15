package com.lee.community.pojo;

import javafx.util.Builder;

import java.util.List;

public class Bbuilding {
    private int bulidingid;
    private int bulidingno;
    private String bulidingname;
    private List<Bunit> bunitList;

    public Bbuilding() {
    }

    public Bbuilding(int bulidingid, int bulidingno, String bulidingname) {
        this.bulidingid = bulidingid;
        this.bulidingno = bulidingno;
        this.bulidingname = bulidingname;
    }

    public int getBulidingid() {
        return bulidingid;
    }

    public void setBulidingid(int bulidingid) {
        this.bulidingid = bulidingid;
    }

    public int getBulidingno() {
        return bulidingno;
    }

    public void setBulidingno(int bulidingno) {
        this.bulidingno = bulidingno;
    }

    public String getBulidingname() {
        return bulidingname;
    }

    public void setBulidingname(String bulidingname) {
        this.bulidingname = bulidingname;
    }

    public List<Bunit> getBunitList() {
        return bunitList;
    }

    public void setBunitList(List<Bunit> bunitList) {
        this.bunitList = bunitList;
    }

    @Override
    public String toString() {
        return "Bbuilding{" +
                "bulidingid=" + bulidingid +
                ", bulidingno=" + bulidingno +
                ", bulidingname='" + bulidingname + '\'' +
                ", bunitList=" + bunitList +
                '}';
    }
}
