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
 * @TableName ads
 */
@TableName(value ="ads")
@Data
public class Ads implements Serializable {
    /**
     * 
     */
    @TableId(value = "ads_id", type = IdType.AUTO)
    private Long adsId;

    /**
     * 
     */
    @TableField(value = "title")
    private String title;

    /**
     * 
     */
    @TableField(value = "content")
    private String content;

    /**
     * 
     */
    @TableField(value = "image_url")
    private String imageUrl;

    /**
     * 
     */
    @TableField(value = "position")
    private String position;

    /**
     * 
     */
    @TableField(value = "sponsor_id")
    private String sponsorId;

    /**
     * 
     */
    @TableField(value = "start_date")
    private LocalDateTime startDate;

    /**
     * 
     */
    @TableField(value = "valid_until")
    private LocalDateTime validUntil;

    /**
     * 
     */
    @TableField(value = "age_limit")
    private Integer ageLimit;

    /**
     * 
     */
    @TableField(value = "region_restrictions")
    private String regionRestrictions;

    /**
     * 
     */
    @TableField(value = "device_restrictions")
    private String deviceRestrictions;

    /**
     * 
     */
    @TableField(value = "click_count")
    private Integer clickCount;

    /**
     * 
     */
    @TableField(value = "exposure_count")
    private Integer exposureCount;

    /**
     * 
     */
    @TableField(value = "weight")
    private Integer weight;

    /**
     * 
     */
    @TableField(value = "redirect_url")
    private String redirectUrl;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}