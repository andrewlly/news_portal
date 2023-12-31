package com.github.news_portal.service.impl;

import com.github.news_portal.domain.ResponseResult;
import com.github.news_portal.domain.entity.User;
import com.github.news_portal.security.LoginUser;
import com.github.news_portal.service.LoginService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Service
public class LoginServiceImpl implements LoginService {

    @Resource
    private AuthenticationManager authenticationManager;

    @Override
    public ResponseResult login(User user) {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword());
        Authentication authenticate;
        try{
            authenticate = authenticationManager.authenticate(token);
        } catch (AuthenticationException e){
            return new ResponseResult<>(403, "Failed login");
        }

        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
        Map<String,String> map = new HashMap<>();
        map.put("token","jwt");
        return new ResponseResult<>(200, "loginSuccess", map);
    }
}
