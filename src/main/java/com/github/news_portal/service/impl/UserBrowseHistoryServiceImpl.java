package com.github.news_portal.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.news_portal.domain.UserBrowseHistory;
import com.github.news_portal.service.UserBrowseHistoryService;
import com.github.news_portal.mapper.UserBrowseHistoryMapper;
import org.springframework.stereotype.Service;

/**
* @author liuyu
* @description 针对表【user_browse_history】的数据库操作Service实现
* @createDate 2023-12-05 17:03:00
*/
@Service
public class UserBrowseHistoryServiceImpl extends ServiceImpl<UserBrowseHistoryMapper, UserBrowseHistory>
    implements UserBrowseHistoryService{
    public void saveOrUpdate(Long userId, Long newsId) {
        UserBrowseHistory userBrowseHistory = new UserBrowseHistory();
        userBrowseHistory.setUserId(userId);
        userBrowseHistory.setNewsId(newsId);
        super.saveOrUpdate(userBrowseHistory);
    }

}




