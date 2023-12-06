package com.github.news_portal.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.news_portal.domain.News;
import com.github.news_portal.domain.User;
import com.github.news_portal.service.NewsService;
import com.github.news_portal.mapper.NewsMapper;
import com.github.news_portal.service.UserBrowseHistoryService;
import com.github.news_portal.util.InputParser;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
* @author liuyu
* @description 针对表【news】的数据库操作Service实现
* @createDate 2023-12-04 23:33:35
*/
@Service
public class NewsServiceImpl extends ServiceImpl<NewsMapper, News>
    implements NewsService{

    @Resource
    NewsMapper newsMapper;

    @Resource
    UserBrowseHistoryService userBrowseHistoryService;
    public boolean save(News news, User user) {
        News validNews = InputParser.parseInput(news);
        validNews.setAuthor(user.getUid());
        return super.save(validNews);
    }

    @Override
    public Page<News> pageQuery(Page<News> pageRequest, News news) {
        LambdaQueryWrapper<News> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(null != news.getAuthor() , News::getAuthor, news.getAuthor());
        wrapper.like(null != news.getTitle(), News::getTitle, news.getTitle());
        wrapper.gt(null != news.getViews(), News::getViews, news.getViews());
        wrapper.gt(null != news.getFavoritesCount(), News::getFavoritesCount, news.getFavoritesCount());
        wrapper.gt(null != news.getShareCount(), News::getShareCount, news.getShareCount());
        wrapper.eq(null != news.getPromoted(), News::getPromoted, news.getPromoted());

        return newsMapper.selectPage(pageRequest, wrapper);
    }

    public boolean updateNewsById(Long newsId, News news) {
        News validNews = InputParser.parseInput(news);
        validNews.setNewsId(newsId);
        return super.updateById(validNews);
    }


    @Transactional
    public News readNews(Long newsId, User user) {
        News news = super.getById(newsId);
        if (news == null) return null;
        userBrowseHistoryService.saveOrUpdate(newsId,user.getUid());
        newsMapper.incrementViews(newsId);
        return news;
    }
}




