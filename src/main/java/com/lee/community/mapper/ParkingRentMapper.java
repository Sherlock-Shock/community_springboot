package com.lee.community.mapper;

import com.lee.community.pojo.ParkingRent;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ParkingRentMapper {
    int addParkingRent(ParkingRent parkingRent);
    int deleteParkingRent(String parkId);
}
