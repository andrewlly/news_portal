package com.github.news_portal.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName news_tag
 */
@TableName(value ="news_tag")
@Data
public class NewsTag implements Serializable {
    /**
     * 
     */
    @TableId(value = "news_tags_id", type = IdType.AUTO)
    private Long newsTagsId;

    /**
     * 
     */
    @TableField(value = "news_id")
    private Long newsId;

    /**
     * 
     */
    @TableField(value = "tag_id")
    private Long tagId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}