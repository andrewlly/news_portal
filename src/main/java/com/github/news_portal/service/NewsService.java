package com.github.news_portal.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.news_portal.domain.entity.News;
import com.baomidou.mybatisplus.extension.service.IService;
import com.github.news_portal.domain.entity.User;

/**
* @author liuyu
* @description 针对表【news】的数据库操作Service
* @createDate 2023-12-04 23:33:35
*/
public interface NewsService extends IService<News> {

    boolean updateNewsById(Long newsId, News news);

    News readNews(Long newsId, User user);

    boolean save(News news, User user);

    Page<News> pageQuery(Page<News> pageRequest, News newsQueryInput);
}
