package com.github.news_portal;


import com.github.news_portal.domain.Ads;
import com.github.news_portal.domain.News;
import com.github.news_portal.mapper.AdsMapper;
import com.github.news_portal.mapper.NewsMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
public class CrudTest {

    @Autowired (required = false)
    NewsMapper newsMapper;

    @Test
    void testMapper(){
        News news = newsMapper.selectById(1L);
        System.out.println(news);
        newsMapper.incrementShareCount(1L);
        news = newsMapper.selectById(1L);
        System.out.println(news);
    }

}
