package com.github.news_portal.web;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.news_portal.domain.entity.Comment;
import com.github.news_portal.service.CommentService;
import com.github.news_portal.util.response.ResponseHandler;
import jakarta.annotation.Resource;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/comment")
public class CommentController {
    @Resource
    CommentService commentService;

    public static final int CommentPageSize = 20;

    @PostMapping()
    public ResponseEntity<Map<String, Object>> createComment(@RequestBody Comment comment) {
        try {
            commentService.save(comment);
        } catch (Exception e) {
            return ResponseHandler.handleErrResponse(e);
        }
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{commentId}")
    public ResponseEntity<Map<String, Object>> getCommentById(@PathVariable Long commentId) {
        return BaseController.getById(commentId, commentService::getById);
    }


    @GetMapping("/{newsId}")
    public ResponseEntity<Map<String, Object>> getParentCommentByNewsId(@PathVariable Long newsId,
                                                                        @RequestParam(defaultValue = "0") int curr) {
        try {
            Page<Comment> pageRequest = new Page<>(curr, CommentPageSize);
            Page<Comment> commentPage = commentService.getParentCommentByNewsId(newsId,pageRequest);
            Map<String, Object> response = new HashMap<>();
            response.put("data", commentPage);
            return ResponseEntity.ok(response);
        } catch (DataIntegrityViolationException e) {
            return ResponseHandler.handleErrResponse(e);
        }
    }

    @GetMapping("/{newsId}/{referencedID}")
    public ResponseEntity<Map<String, Object>> getSubComment(@PathVariable Long newsId,
                                                             @PathVariable Long referencedID,
                                                             @RequestParam(defaultValue = "0") int curr) {
        try {
            Page<Comment> pageRequest = new Page<>(curr, CommentPageSize);
            Page<Comment> commentPage = commentService.getSubCommentsByParentId(newsId,referencedID,pageRequest);
            Map<String, Object> response = new HashMap<>();
            response.put("data", commentPage);
            return ResponseEntity.ok(response);
        } catch (DataIntegrityViolationException e) {
            return ResponseHandler.handleErrResponse(e);
        }
    }

    @PutMapping("/{commentId}")
    public ResponseEntity<Map<String, Object>> updateComment(@PathVariable Long commentId, @RequestBody Comment comment) {
        try{
            commentService.updateById(commentId,comment);
        }catch (Exception e){
            return ResponseHandler.handleErrResponse(e);
        }
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{commentId}")
    public ResponseEntity<Map<String, Object>> deleteComment(@PathVariable Long commentId) {
        boolean isDeleted = commentService.removeById(commentId);
        if (isDeleted) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseHandler.buildErrResponse("Recourse not exist", HttpStatus.NOT_FOUND);
        }
    }
}
