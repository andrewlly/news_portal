package com.github.news_portal.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.news_portal.domain.entity.Comment;
import com.github.news_portal.service.CommentService;
import com.github.news_portal.mapper.CommentMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author liuyu
* @description 针对表【comment】的数据库操作Service实现
* @createDate 2023-12-04 23:33:35
*/
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment>
    implements CommentService{

    @Resource
    CommentMapper commentMapper;
    @Override
    public Page<Comment> getParentCommentByNewsId(Long newsId, Page<Comment> page) {
        LambdaQueryWrapper<Comment> wrapper = new LambdaQueryWrapper<>();
        wrapper.isNull(Comment::getReferencedCommentId)
                .eq(Comment::getNewsId, newsId);
        return commentMapper.selectPage(page,wrapper);
    }


    public Page<Comment> getSubCommentsByParentId(Long parentCommentId, Long newsId, Page<Comment> page) {
        LambdaQueryWrapper<Comment> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Comment::getReferencedCommentId, parentCommentId)
                .eq(Comment::getNewsId, newsId);
        return commentMapper.selectPage(page,wrapper);
    }

    @Override
    public boolean updateById(Long commentId, Comment comment) {
        return super.updateById(comment);
    }
}




