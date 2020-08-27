package com.lee.community.serviceimpl;

import com.lee.community.mapper.UsersMapper;
import com.lee.community.pojo.Users;
import com.lee.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UsersMapper usersMapper;

    @Override
    public int updatePassword(Users users) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        final String rawPassword = users.getPassword();
        users.setPassword(encoder.encode(rawPassword) );
        return usersMapper.updatePassword(users);
    }

    @Override
    public int updatePhotoById(String userid) {
        return usersMapper.updatePhotoById(userid);
    }

    @Override
    public int updateUserIdByPhone(String phone,String userId) {
        return usersMapper.updateUserIdByPhone(phone,userId);
    }

    @Override
    public int resetOwnerPassword(String ownerId) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String codePassword =  encoder.encode("123456");
        return usersMapper.resetOwnerPassword(codePassword,ownerId);
    }

    @Override
    public int deleteUsers(String[] userId) {
        return usersMapper.deleteUsers(userId);
    }
}
