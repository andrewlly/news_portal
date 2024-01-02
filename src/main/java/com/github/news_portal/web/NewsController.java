package com.github.news_portal.web;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.news_portal.domain.entity.Ads;
import com.github.news_portal.domain.entity.Comment;
import com.github.news_portal.domain.entity.News;

import com.github.news_portal.domain.entity.User;
import com.github.news_portal.security.LoginUser;
import com.github.news_portal.service.AdsService;
import com.github.news_portal.service.CommentService;
import com.github.news_portal.service.NewsService;
import com.github.news_portal.util.response.ResponseHandler;
import jakarta.annotation.Resource;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/news")
public class NewsController {
    private static final int PageSize = 20;
    @Resource
    NewsService newsService;

    @Resource
    AdsService adsService;

    @Resource
    CommentService commentService;


    @PreAuthorize("hasAuthority('home:view')")
    @GetMapping()
    public ResponseEntity<Map<String, Object>> getNews(
            @RequestParam(defaultValue = "0") int page,
            @RequestBody News newsQueryInput) {

        try {
            Page<News> pageRequest = new Page<>(page, PageSize);
            Page<News> newsPage = newsService.pageQuery(pageRequest,newsQueryInput);
            Map<String, Object> response = new HashMap<>();
            Ads mainPageAd = adsService.getMainPageAds();
            response.put("data", newsPage);
            response.put("mainPageAd", mainPageAd);

            return ResponseEntity.ok(response);
        } catch (DataIntegrityViolationException e) {
            return ResponseHandler.handleErrResponse(e);
        }
    }

    @GetMapping("/select/{newsId}")
    public ResponseEntity<Map<String, Object>> getNewsById(@PathVariable Long newsId) {
        return BaseController.getById(newsId, newsService::getById);
    }

    @PreAuthorize("hasAuthority('home:view')")
    @GetMapping("/{newsId}")
    public ResponseEntity<Map<String, Object>> readNewsById(@PathVariable Long newsId, @RequestBody User user) {
        try {
            News news = newsService.readNews(newsId,user);
            Map<String, Object> response = new HashMap<>();
            if (news != null) {
                Page<Comment> page = new Page<>(0,CommentController.CommentPageSize);
                commentService.getParentCommentByNewsId(newsId,page);
                response.put("data", news);
                response.put("comments",page);
                response.put("commentAd", adsService.getCommentAds());
                return ResponseEntity.ok(response);
            } else {
                return ResponseHandler.buildErrResponse("Recourse not exist", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return ResponseHandler.handleErrResponse(e);
        }
    }

    @PreAuthorize("hasAuthority('news:create')")
    @PostMapping()
    public ResponseEntity<Map<String, Object>> createNews(@RequestBody News news) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Long userId = null;
        if (authentication != null && authentication.getPrincipal() instanceof LoginUser loginUser) {
             userId = loginUser.getUser().getUid();
        }
        try {
            newsService.save(news,userId);
        } catch (Exception e) {
            return ResponseHandler.handleErrResponse(e);
        }
        return ResponseEntity.noContent().build();
    }

    @PreAuthorize("hasAuthority('news:update')")
    @PostMapping("/{newsID}")
    public ResponseEntity<Map<String, Object>> updateNews(@PathVariable Long newsID, @RequestBody News news) {
        try{
            newsService.updateNewsById(newsID,news);
        }catch (Exception e){
            return ResponseHandler.handleErrResponse(e);
        }
        return ResponseEntity.noContent().build();
    }

    @PreAuthorize("hasAuthority('news:delete')")
    @DeleteMapping("/{newsID}")
    public ResponseEntity<Map<String, Object>> deleteNews(@PathVariable Long newsID) {
        boolean isDeleted = newsService.removeById(newsID);
        if (isDeleted) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseHandler.buildErrResponse("Recourse not exist", HttpStatus.NOT_FOUND);
        }
    }


}
