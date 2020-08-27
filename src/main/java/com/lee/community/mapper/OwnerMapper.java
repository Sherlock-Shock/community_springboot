package com.lee.community.mapper;

import com.lee.community.pojo.Owner;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OwnerMapper {
    List<Owner> queryOwner(Owner owner);
    int addOwner(Owner owner);
    int deleteOwners(String[] ownerIds);
    Owner queryOwnerById(String ownerId);
    int updatePhotoById(String ownerId);
    int queryOwnerTotal();
    int updateOwnerById(Owner owner);
    String queryOwnerIdByPhone(String phone);
    Owner queryOwnerMessageByPhone(String phone);

}
