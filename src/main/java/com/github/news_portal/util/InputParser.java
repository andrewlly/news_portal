package com.github.news_portal.util;

import com.github.news_portal.domain.News;
import com.github.news_portal.domain.User;

public class InputParser {
    public static User parseInput(User user){
        user.setUid(null);
        user.setCreationDate(null);
        user.setLatestLogin(null);
        user.setUserLevel(null);
        return user;
    }

    public static News parseInput(News news){
        news.setNewsId(null);
        news.setPromoted(null);
        news.setPostDate(null);
        news.setViews(null);
        news.setFavoritesCount(null);
        news.setShareCount(null);
        return news;
    }
}
