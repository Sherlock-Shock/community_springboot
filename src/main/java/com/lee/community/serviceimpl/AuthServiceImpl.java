package com.lee.community.serviceimpl;

import com.lee.community.pojo.LoginInfo;
import com.lee.community.pojo.Users;
import com.lee.community.mapper.UsersMapper;
import com.lee.community.service.AuthService;
import com.lee.community.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UsersMapper usersMapper;

    // 登录
    @Override
    public LoginInfo login(String username, String password ) {
        UsernamePasswordAuthenticationToken upToken = new UsernamePasswordAuthenticationToken( username, password );
        final Authentication authentication = authenticationManager.authenticate(upToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final UserDetails userDetails = userDetailsService.loadUserByUsername( username );
        String userrole = userDetails.getAuthorities().toString();
        final String token = jwtTokenUtil.generateToken(userDetails);
        return new LoginInfo(username,userrole,token);
    }

     //注册
    @Override
    public int register( Users userToAdd ) {

        final String username = userToAdd.getUsername();
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        final String rawPassword = userToAdd.getPassword();
        userToAdd.setPassword( encoder.encode(rawPassword) );
        return usersMapper.addUser(userToAdd);
    }

    @Override
    public int checkUserIsExist(String userId) {
        return usersMapper.checkUserIsExist(userId);
    }
}
