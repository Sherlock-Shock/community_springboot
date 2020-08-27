package com.lee.community.serviceimpl;

import com.lee.community.mapper.OwnerMapper;
import com.lee.community.pojo.Bhouse;
import com.lee.community.pojo.Owner;
import com.lee.community.pojo.Parking;
import com.lee.community.pojo.Users;
import com.lee.community.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class OwnerServiceImpl implements OwnerService {

    @Autowired
    OwnerMapper ownerMapper;
    @Autowired
    AuthService authService;

    @Autowired
    PropertyService propertyService;
    @Autowired
    ParkingService parkingService ;
    @Autowired
    UserService userService;


    @Override
    public List<Owner> queryOwner(Owner owner) {
        return ownerMapper.queryOwner(owner);
    }

    @Override
    public int addOwner(Owner owner) {

        if(authService.checkUserIsExist(owner.getPhone())>0){
            return 1001;
        }
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        owner.setOwnerId(String.valueOf(System.currentTimeMillis()));
        owner.setCreateTime(df.format(System.currentTimeMillis()));
        Users users = new Users();
        users.setUserrole("NORMAL");
        users.setUsername(owner.getOwnerName());
        users.setPassword("123456");
        users.setUserid(owner.getPhone());
        authService.register(users);
        return ownerMapper.addOwner(owner);
    }

    @Override
    public int deleteOwners(String[] ownerIds) {
        List<String> userIds = new ArrayList<>();
        for(String ownerId : ownerIds){
            userIds.add(ownerMapper.queryOwnerById(ownerId).getPhone());
        }
        userService.deleteUsers(userIds.toArray((new String[userIds.size()])));
        return ownerMapper.deleteOwners(ownerIds);
    }

    @Override
    public Owner queryOwnerById(String ownerId) {
        return ownerMapper.queryOwnerById(ownerId);
    }

    @Override
    public int updatePhotoById(String ownerId) {
        return ownerMapper.updatePhotoById(ownerId);
    }

    @Override
    public int queryOwnerTotal() {
        return ownerMapper.queryOwnerTotal();
    }

    @Override
    public String queryOwnerIdByPhone(String phone) {
        return ownerMapper.queryOwnerIdByPhone(phone);
    }

    @Override
    public Owner queryOwnerMessageByPhone(String phone) {
        return ownerMapper.queryOwnerMessageByPhone(phone);
    }

    @Override
    public int updateOwnerById(Owner owner) {
        if(owner.getPhone().equals("")&&owner.getPhone()!=null){
            Owner owner1 =  ownerMapper.queryOwnerById(owner.getOwnerId());
            userService.updateUserIdByPhone(owner.getPhone(),owner1.getPhone());
        }
        return ownerMapper.updateOwnerById(owner);
    }

    @Override
    public List<Bhouse> queryOwnerAllHouse(String ownerId) {
        return propertyService.queryOwnerAllHouse(ownerId);
    }

    @Override
    public List<Map> queryOwnerAllParking(String ownerId) {
        return parkingService.queryOwnerAllParking(ownerId);
    }

    @Override
    public int dropHouseById(String houseId) {
        return propertyService.updateHouseOwnerDrop(houseId);
    }

    @Override
    public int dropParkingById(String parkId) {
        parkingService.deleteParkingRent(parkId);
        return parkingService.updateParkingOwnerDrop(parkId);
    }
}
