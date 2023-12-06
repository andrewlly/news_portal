package com.github.news_portal.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.news_portal.domain.NewsTag;
import com.github.news_portal.service.NewsTagService;
import com.github.news_portal.mapper.NewsTagMapper;
import org.springframework.stereotype.Service;

/**
* @author liuyu
* @description 针对表【news_tag】的数据库操作Service实现
* @createDate 2023-12-04 23:33:35
*/
@Service
public class NewsTagServiceImpl extends ServiceImpl<NewsTagMapper, NewsTag>
    implements NewsTagService{

}




