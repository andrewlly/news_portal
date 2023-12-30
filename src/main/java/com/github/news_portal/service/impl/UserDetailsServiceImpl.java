package com.github.news_portal.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.news_portal.domain.User;
import com.github.news_portal.mapper.UserMapper;
import com.github.news_portal.security.LoginUser;
import jakarta.annotation.Resource;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Resource
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(User::getUserName, username);
        User user = userMapper.selectOne(lambdaQueryWrapper);
        if(Objects.isNull(user)){
            throw new RuntimeException("invalid account");
        }
        //todo: access check
        return new LoginUser(user);
    }


}
