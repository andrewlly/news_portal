package com.github.news_portal.web;


import com.github.news_portal.domain.ResponseResult;
import com.github.news_portal.domain.entity.User;
import com.github.news_portal.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/auth/login")
    public ResponseResult login(@RequestBody User user){
        return loginService.login(user);
    }
}
