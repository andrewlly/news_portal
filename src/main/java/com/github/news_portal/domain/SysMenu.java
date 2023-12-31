package com.github.news_portal.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName sys_menu
 */
@TableName(value ="sys_menu")
@Data
public class SysMenu implements Serializable {
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
    @TableField(value = "del_flag")
    private Integer delFlag;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}