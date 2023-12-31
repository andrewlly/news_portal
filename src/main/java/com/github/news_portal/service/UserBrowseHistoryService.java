package com.github.news_portal.service;

import com.github.news_portal.domain.entity.UserBrowseHistory;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author liuyu
* @description 针对表【user_browse_history】的数据库操作Service
* @createDate 2023-12-05 17:03:00
*/
public interface UserBrowseHistoryService extends IService<UserBrowseHistory> {

    void saveOrUpdate(Long newsId, Long uid);
}
