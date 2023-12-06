package com.github.news_portal.service;

import com.github.news_portal.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author liuyu
* @description 针对表【user】的数据库操作Service
* @createDate 2023-12-04 23:33:35
*/
public interface UserService extends IService<User> {
    public boolean updateUserById(Long uid, User user);
}
