package com.github.news_portal.service;

import com.github.news_portal.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;


public interface UserService extends IService<User> {
    boolean updateUserById(Long uid, User user);

}
