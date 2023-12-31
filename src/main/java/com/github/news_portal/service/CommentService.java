package com.github.news_portal.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.news_portal.domain.entity.Comment;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author liuyu
* @description 针对表【comment】的数据库操作Service
* @createDate 2023-12-04 23:33:35
*/
public interface CommentService extends IService<Comment> {

    Page<Comment> getParentCommentByNewsId(Long newsId,Page<Comment> page);

    Page<Comment> getSubCommentsByParentId(Long parentCommentId, Long newsId, Page<Comment> pageRequest);

    boolean updateById(Long commentId, Comment comment);
}
