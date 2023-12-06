package com.github.news_portal.mapper;

import com.github.news_portal.domain.Ads;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
* @author liuyu
* @description 针对表【ads】的数据库操作Mapper
* @createDate 2023-12-04 23:33:35
* @Entity com.github.news_portal.domain.Ads
*/
public interface AdsMapper extends BaseMapper<Ads> {

    @Update("UPDATE ad SET exposure_count = exposure_count + 1 WHERE ad_id = #{adId}")
    void incrementExposureCount(@Param("adId") Long adId);

    @Update("UPDATE ad SET click_count = click_count + 1 WHERE ad_id = #{adId}")
    void incrementClickCount(@Param("adId") Long adId);

    @Select("SELECT * FROM Ads WHERE position = #{position} ORDER BY (weight - click_count*100 - exposure_count) DESC")
    List<Ads> selectTopByPos(String position);


}




