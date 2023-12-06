package com.github.news_portal.service;

import com.github.news_portal.domain.Ads;
import com.baomidou.mybatisplus.extension.service.IService;

import java.io.Serializable;

/**
* @author liuyu
* @description 针对表【ads】的数据库操作Service
* @createDate 2023-12-04 23:33:35
*/
public interface AdsService extends IService<Ads> {

    Ads getMainPageAds();

    Object getCommentAds();
}
