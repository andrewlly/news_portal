package com.github.news_portal.domain.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName sys_menu
 */
@TableName(value ="sys_menu")
@Data
public class Menu implements Serializable {
    /**
     * 
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 
     */
    @TableField(value = "menu_name")
    private String menuName;

    /**
     * 
     */
    @TableField(value = "path")
    private String path;

    /**
     * 
     */
    @TableField(value = "component")
    private String component;

    /**
     * 
     */
    @TableField(value = "visible")
    private String visible;

    /**
     * 
     */
    @TableField(value = "status")
    private String status;

    /**
     * 
     */
    @TableField(value = "perms")
    private String perms;

    /**
     * 
     */
    @TableField(value = "icon")
    private String icon;

    /**
     * 
     */
    @TableLogic
    private Integer delFlag;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}