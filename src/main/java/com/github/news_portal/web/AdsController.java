package com.github.news_portal.web;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.news_portal.domain.Ads;
import com.github.news_portal.service.AdsService;
import com.github.news_portal.util.response.ResponseHandler;
import jakarta.annotation.Resource;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/ads")
public class AdsController {
    private static final int PageSize = 20;
    @Resource
    AdsService adsService;

    @GetMapping()
    public ResponseEntity<Map<String, Object>> getAllAds(@RequestParam(defaultValue = "0") int page) {
        try {
            Page<Ads> pageRequest = new Page<>(page, PageSize);
            Page<Ads> adsPage = adsService.page(pageRequest);
            Map<String, Object> response = new HashMap<>();
            response.put("data", adsPage);

            return ResponseEntity.ok(response);
        } catch (DataIntegrityViolationException e) {
            return ResponseHandler.handleErrResponse(e);
        }
    }

    @GetMapping("/{adsId}")
    public ResponseEntity<Map<String, Object>> getAdsById(@PathVariable Long adsId) {
        return BaseController.getById(adsId, adsService::getById);
    }

    @PostMapping()
    public ResponseEntity<Map<String, Object>> createAds(@RequestBody Ads ads) {
        try {
            adsService.save(ads);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseHandler.handleErrResponse(e);
        }
    }

    @PutMapping()
    public ResponseEntity<Map<String, Object>> updateAds(@RequestBody Ads ads) {
        try {
            adsService.updateById(ads);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseHandler.handleErrResponse(e);
        }
    }

    @DeleteMapping("/{adsId}")
    public ResponseEntity<Map<String, Object>> deleteAds(@PathVariable Long adsId) {
        boolean isDeleted = adsService.removeById(adsId);
        if (isDeleted) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseHandler.buildErrResponse("Resource not exist", HttpStatus.NOT_FOUND);
        }
    }
}
