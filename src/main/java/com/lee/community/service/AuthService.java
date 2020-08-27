package com.lee.community.service;

import com.lee.community.pojo.LoginInfo;
import com.lee.community.pojo.Users;

public interface AuthService {

    int register(Users userToAdd);
    LoginInfo login(String username, String password);
    int checkUserIsExist(String userId);

}
