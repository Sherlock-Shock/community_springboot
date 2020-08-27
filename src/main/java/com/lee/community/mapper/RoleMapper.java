package com.lee.community.mapper;

import com.lee.community.pojo.UserRole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoleMapper {
    List<UserRole> queryUserRole(String userId);
}
