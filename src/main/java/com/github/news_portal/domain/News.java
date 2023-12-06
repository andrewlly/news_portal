package com.github.news_portal.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * 
 * @TableName news
 */
@TableName(value ="news")
@Data
public class News implements Serializable {
    /**
     * 
     */
    @TableId(value = "news_id", type = IdType.AUTO)
    private Long newsId;

    /**
     * 
     */
    @TableField(value = "author")
    private Long author;

    /**
     * 
     */
    @TableField(value = "title")
    private String title;

    /**
     * 
     */
    @TableField(value = "post_date")
    private LocalDateTime postDate;

    /**
     * 
     */
    @TableField(value = "thumbnail")
    private String thumbnail;

    /**
     * 
     */
    @TableField(value = "content")
    private String content;

    /**
     * 
     */
    @TableField(value = "views")
    private Integer views;

    /**
     * 
     */
    @TableField(value = "favorites_count")
    private Integer favoritesCount;

    /**
     * 
     */
    @TableField(value = "share_count")
    private Integer shareCount;

    /**
     * 
     */
    @TableField(value = "promoted")
    private Integer promoted;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}