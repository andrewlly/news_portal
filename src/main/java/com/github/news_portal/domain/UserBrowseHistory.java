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
 * @TableName user_browse_history
 */
@TableName(value ="user_browse_history")
@Data
public class UserBrowseHistory implements Serializable {
    /**
     * 
     */
    @TableId(value = "user_browse_history_id", type = IdType.AUTO)
    private Long userBrowseHistoryId;

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

    /**
     * 
     */
    @TableField(value = "last_view_date")
    private LocalDateTime lastViewDate;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}