package com.github.news_portal.service;

import com.github.news_portal.domain.ResponseResult;
import com.github.news_portal.domain.User;

public interface LoginService {

    ResponseResult login(User user);
}
