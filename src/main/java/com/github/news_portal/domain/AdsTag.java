package com.github.news_portal.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName ads_tag
 */
@TableName(value ="ads_tag")
@Data
public class AdsTag implements Serializable {
    /**
     * 
     */
    @TableId(value = "ads_tag_id", type = IdType.AUTO)
    private Long adsTagId;

    /**
     * 
     */
    @TableField(value = "ads_id")
    private Long adsId;

    /**
     * 
     */
    @TableField(value = "tag_id")
    private Long tagId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}