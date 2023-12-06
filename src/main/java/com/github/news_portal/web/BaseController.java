package com.github.news_portal.web;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.github.news_portal.domain.News;
import com.github.news_portal.domain.User;
import com.github.news_portal.util.response.ResponseHandler;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

public class BaseController {
    public static <T> ResponseEntity<Map<String, Object>> getById(Long id,
                                                           Function<Long, T> fetchFunction) {
        try {
            T entity = fetchFunction.apply(id);
            if (entity != null) {
                Map<String, Object> response = new HashMap<>();
                response.put("data", entity);
                return ResponseEntity.ok(response);
            } else {
                return ResponseHandler.buildErrResponse("Resource not found", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return ResponseHandler.handleErrResponse(e);
        }
    }



}
