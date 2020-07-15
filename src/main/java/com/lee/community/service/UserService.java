package com.lee.community.service;

import com.lee.community.pojo.Users;

public interface UserService {
    int updatePassword(Users users);
    int updatePhotoById(String userid);
    int updateUserIdByPhone(String phone,String userId);
    int resetOwnerPassword(String ownerId);
    int deleteUsers(String[] userId);
}
