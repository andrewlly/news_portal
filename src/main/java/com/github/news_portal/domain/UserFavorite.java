package com.github.news_portal.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName user_favorite
 */
@TableName(value ="user_favorite")
@Data
public class UserFavorite implements Serializable {
    /**
     * 
     */
    @TableId(value = "user_favorite_id", type = IdType.AUTO)
    private Long userFavoriteId;

    /**
     * 
     */
    @TableField(value = "user_id")
    private Long userId;

    /**
     * 
     */
    @TableField(value = "news_id")
    private Long newsId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}