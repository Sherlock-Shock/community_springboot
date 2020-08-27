package com.lee.community.pojo;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;


import java.sql.Timestamp;

public class Owner {
    @ExcelProperty(value = "ID")
    private  String ownerId;
    @ExcelIgnore
    private int houseId;
    @ExcelProperty(value = "姓名")
    private  String ownerName;
    @ExcelProperty(value = "性别")
    private  String sex;
    @ExcelProperty(value = "身份证号")
    private  String idCard;
    @ExcelProperty(value = "联系电话")
    private  String phone;
    @ExcelIgnore
    private  String photo;
    @ExcelProperty(value = "邮箱")
    private  String email;
    @ExcelProperty(value = "籍贯")
    private  String address;
    @ExcelIgnore
    private String createTime;

    public Owner() {
    }

    public Owner(String ownerId, int houseId, String ownerName, String sex, String idCard, String phone, String photo, String email, String address, String createTime) {
        this.ownerId = ownerId;
        this.houseId = houseId;
        this.ownerName = ownerName;
        this.sex = sex;
        this.idCard = idCard;
        this.phone = phone;
        this.photo = photo;
        this.email = email;
        this.address = address;
        this.createTime = createTime;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public int getHouseId() {
        return houseId;
    }

    public void setHouseId(int houseId) {
        this.houseId = houseId;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "ownerId='" + ownerId + '\'' +
                ", houseId=" + houseId +
                ", ownerName='" + ownerName + '\'' +
                ", sex='" + sex + '\'' +
                ", idCard='" + idCard + '\'' +
                ", phone='" + phone + '\'' +
                ", photo='" + photo + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
