package com.lee.community;

import com.lee.community.mapper.BbuildingMapper;
import com.lee.community.mapper.BhouseMapper;
import com.lee.community.mapper.BunitMapper;
import com.lee.community.mapper.UsersMapper;
import com.lee.community.pojo.Bhouse;
import com.lee.community.pojo.Users;
import com.lee.community.service.AuthService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CommunityApplicationTests {


    @Autowired
    UsersMapper usersMapper;
    @Autowired
    BunitMapper bunitMapper;
    @Autowired
    BhouseMapper bouseMapper;
    @Autowired
    BbuildingMapper bbuildingMapper;
    @Autowired
    AuthService authService;

    @Test
    void contextLoads() {
        //usersService.queryUsers();
        Users user = new Users();
        user.setUserid("13066288756");
        user.setUsername("赵四");
        user.setPassword("123456");
        user.setUserrole("NORMAL");

        System.out.println("测试打印"+authService.register(user));
    }

}
