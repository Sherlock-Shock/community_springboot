package com.lee.community.mapper;

import com.lee.community.pojo.Student;
import com.lee.community.pojo.Users;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UsersMapper {
    public List<Users> queryUsers();
    Users queryUserById(String userid);
    Users queryUserByName(String username);
    int addUser(Users users);
    int checkUserIsExist(String userId);
    int deleteUsers(String[] userId);
    int updatePassword(Users users);
    int updatePhotoById(String userid);
    int updateUserIdByPhone(@Param("phone") String phone,@Param("userId") String userId);
    int resetOwnerPassword(@Param("password") String password,@Param("ownerId") String ownerId);

    List<Student> findStuAndTea();
}
