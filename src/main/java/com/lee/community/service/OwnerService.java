package com.lee.community.service;

import com.lee.community.pojo.Bhouse;
import com.lee.community.pojo.Owner;
import com.lee.community.pojo.Parking;

import java.util.List;
import java.util.Map;

public interface OwnerService {
    List<Owner> queryOwner(Owner owner);
    int addOwner(Owner owner);
    int deleteOwners(String[] ownerIds);
    Owner queryOwnerById(String ownerId);
    int updatePhotoById(String ownerId);
    int queryOwnerTotal();
    int updateOwnerById(Owner owner);
    String queryOwnerIdByPhone(String phone);
    Owner queryOwnerMessageByPhone(String phone);

    List<Bhouse> queryOwnerAllHouse(String ownerId);
    List<Map> queryOwnerAllParking(String ownerId);
    int dropHouseById(String houseId);
    int dropParkingById(String parkId);
}
