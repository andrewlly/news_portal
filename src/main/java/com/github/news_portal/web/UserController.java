package com.github.news_portal.web;


import com.github.news_portal.domain.entity.User;
import javax.annotation.Resource;

import com.github.news_portal.service.UserService;
import com.github.news_portal.util.response.ResponseHandler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@RequestMapping("/user")
public class UserController {


    @Resource
    UserService userService;



    @PostMapping ("/login")
    @ResponseBody
    private ResponseEntity<Map<String, Object>> saveUser(@RequestBody User user) {
        try {
            userService.save(user);
        } catch (Exception e) {
            return ResponseHandler.handleErrResponse(e);
        }

        return ResponseEntity.noContent().build();
    }


    @PostMapping ("/{uid}")
    @ResponseBody
    private ResponseEntity<Map<String, Object>> updateUserByID(@PathVariable Long uid, @RequestBody User user) {
        try {
            userService.updateUserById(uid,user);
        } catch (Exception e) {
            return ResponseHandler.handleErrResponse(e);
        }

        return ResponseEntity.noContent().build();
    }





}
