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
 * @TableName comment
 */
@TableName(value ="comment")
@Data
public class Comment implements Serializable {
    /**
     * 
     */
    @TableId(value = "comment_id", type = IdType.AUTO)
    private Long commentId;

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
    @TableField(value = "content")
    private String content;

    /**
     * 
     */
    @TableField(value = "timestamp")
    private LocalDateTime timestamp;

    /**
     * 
     */
    @TableField(value = "referenced_comment_id")
    private Long referencedCommentId;

    /**
     * 
     */
    @TableField(value = "upvotes")
    private Integer upvotes;

    /**
     * 
     */
    @TableField(value = "downvotes")
    private Integer downvotes;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}