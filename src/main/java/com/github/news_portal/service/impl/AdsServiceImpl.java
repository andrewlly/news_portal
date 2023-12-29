package com.github.news_portal.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.news_portal.domain.Ads;
import com.github.news_portal.service.AdsService;
import com.github.news_portal.mapper.AdsMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.Serializable;

/**
* @author liuyu
* @description 针对表【ads】的数据库操作Service实现
* @createDate 2023-12-04 23:33:35
*/
@Service
public class AdsServiceImpl extends ServiceImpl<AdsMapper, Ads>
    implements AdsService{

    @Resource
    AdsMapper adsMapper;


    @Override
    public Ads getById(Serializable id) {
        adsMapper.incrementExposureCount((Long) id);
        return super.getById(id);
    }

    @Override
    @Transactional
    public Ads getMainPageAds() {
        Ads ads = adsMapper.selectTopByPos("main page").get(0);
        adsMapper.incrementExposureCount(ads.getAdsId());
        return ads;
    }


    @Transactional
    public Ads getCommentAds() {
        Ads ads = adsMapper.selectTopByPos("comment").get(0);
        adsMapper.incrementExposureCount(ads.getAdsId());
        return ads;
    }
}




