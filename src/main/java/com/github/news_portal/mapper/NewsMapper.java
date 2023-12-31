package com.github.news_portal.mapper;

import com.github.news_portal.domain.entity.News;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
* @author liuyu
* @description 针对表【news】的数据库操作Mapper
* @createDate 2023-12-04 23:33:35
* @Entity com.github.news_portal.domain.entity.News
*/
public interface NewsMapper extends BaseMapper<News> {
    @Update("UPDATE news SET views = views + 1 WHERE news_id = #{newsId}")
    void incrementViews(@Param("newsId") Long newsId);

    @Update("UPDATE news SET favorites_count = favorites_count + 1 WHERE news_id = #{newsId}")
    void incrementFavoritesCount(@Param("newsId") Long newsId);
    @Update("UPDATE news SET share_count = share_count + 1 WHERE news_id = #{newsId}")
    void incrementShareCount(@Param("newsId") Long newsId);
}




