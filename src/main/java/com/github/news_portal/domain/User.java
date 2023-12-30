package com.github.news_portal.domain;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * 
 * @TableName user
 */
@TableName(value ="user")
@Data
public class User implements Serializable {
    /**
     * 
     */
    @TableId(value = "uid", type = IdType.AUTO)
    private Long uid;

    /**
     * 
     */
    @TableField(value = "user_name")
    private String userName;

    /**
     * 
     */
    @TableField(value = "phone_number")
    private String phoneNumber;

    /**
     * 
     */
    @TableField(value = "email")
    private String email;

    /**
     * 
     */
    @TableField(value = "avatar_url")
    private String avatarUrl;

    /**
     * 
     */
    @TableField(value = "latest_login")
    private LocalDateTime latestLogin;

    /**
     * 
     */
    @TableField(value = "creation_date")
    private LocalDateTime creationDate;

    /**
     * 
     */
    @TableField(value = "bio")
    private String bio;

    /**
     * 
     */
    @TableField(value = "user_level")
    private Integer userLevel;

    @TableField(value = "sex")
    private Integer sex;

    @TableField(value = "password")
    private String password;

    @TableLogic
    private Integer isDeleted;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}