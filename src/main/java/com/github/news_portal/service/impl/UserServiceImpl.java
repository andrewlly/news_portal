package com.github.news_portal.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.news_portal.domain.User;
import com.github.news_portal.security.LoginUser;
import com.github.news_portal.service.UserService;
import com.github.news_portal.mapper.UserMapper;
import com.github.news_portal.util.InputParser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;


@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

    @Resource
    UserMapper userMapper;

    @Override
    public boolean save(User user) {
        User validUser = InputParser.parseInput(user);
        return super.save(validUser);
    }


    public boolean updateUserById(Long uid, User user) {
        User validUser = InputParser.parseInput(user);
        user.setUid(uid);
        int i = userMapper.updateById(validUser);
        return i != 0;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(User::getUserName, username);
        User user = userMapper.selectOne(lambdaQueryWrapper);
        if(Objects.isNull(user)){
            return null;
        }
        //todo: access check
        return new LoginUser(user);
    }
}




