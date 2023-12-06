package com.github.news_portal.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.news_portal.domain.UserFavorite;
import com.github.news_portal.service.UserFavoriteService;
import com.github.news_portal.mapper.UserFavoriteMapper;
import org.springframework.stereotype.Service;

/**
* @author liuyu
* @description 针对表【user_favorite】的数据库操作Service实现
* @createDate 2023-12-04 23:33:35
*/
@Service
public class UserFavoriteServiceImpl extends ServiceImpl<UserFavoriteMapper, UserFavorite>
    implements UserFavoriteService{

}




