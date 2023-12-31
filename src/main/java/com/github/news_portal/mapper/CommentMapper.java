package com.github.news_portal.mapper;

import com.github.news_portal.domain.entity.Comment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
* @author liuyu
* @description 针对表【comment】的数据库操作Mapper
* @createDate 2023-12-04 23:33:35
* @Entity com.github.news_portal.domain.entity.Comment
*/
public interface CommentMapper extends BaseMapper<Comment> {

    @Select("SELECT * FROM Comment WHERE referenced_comment_id IS NULL AND news_id = #{newsId}")
    List<Comment> getAllParentComments(@Param("newsId") Long newsId);

    @Select("SELECT * FROM Comment WHERE referenced_comment_id = #{parentCommentId} AND news_id = #{newsId}")
    List<Comment> getSubCommentsByParentId(@Param("parentCommentId") Long parentCommentId,
                                           @Param("newsId") Long newsId);
}




