package com.github.news_portal.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.news_portal.domain.entity.User;
import com.github.news_portal.service.UserService;
import com.github.news_portal.mapper.UserMapper;
import com.github.news_portal.util.InputParser;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;


@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

    @Resource
    UserMapper userMapper;
    @Resource
    PasswordEncoder encoder;

    @Override
    public boolean save(User user) {
        //todo: check input;
        User validUser = InputParser.parseInput(user);
        validUser.setPassword(encoder.encode(user.getPassword()));
        return super.save(validUser);
    }


    public boolean updateUserById(Long uid, User user) {
        User validUser = InputParser.parseInput(user);
        user.setUid(uid);
        int i = userMapper.updateById(validUser);
        return i != 0;
    }

}




