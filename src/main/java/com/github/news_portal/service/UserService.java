package com.github.news_portal.service;

import com.github.news_portal.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.security.core.userdetails.UserDetails;


public interface UserService extends IService<User> {
    boolean updateUserById(Long uid, User user);

    UserDetails loadUserByUsername(String username);
}
