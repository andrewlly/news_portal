package com.github.news_portal.web;

import com.github.news_portal.util.response.ResponseHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;
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
