package com.lee.community.serviceimpl;

import com.lee.community.mapper.RoleMapper;
import com.lee.community.mapper.UsersMapper;
import com.lee.community.pojo.UserRole;
import com.lee.community.pojo.Users;

import jdk.nashorn.internal.runtime.logging.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MyUsersDetailService implements UserDetailsService {

    @Autowired
    UsersMapper usersMapper;
    @Autowired
    RoleMapper roleMapper;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = usersMapper.queryUserById(username);
        if (user == null) {
            throw new UsernameNotFoundException("用户不存在");
        }

//        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
//        List<UserRole> roles =  roleMapper.queryUserRole(user.getUserid());
//        for(UserRole role:roles)
//        {
//            authorities.add(new SimpleGrantedAuthority(role.getName()));
//            //System.out.println(role.getName());
//        }
//        return new org.springframework.security.core.userdetails.User(user.getUserid(),
//                user.getPassword(), authorities);
        return User.withUsername(user.getUserid()).password(user.getPassword()).roles(user.getUserrole()).build();
    }
}
