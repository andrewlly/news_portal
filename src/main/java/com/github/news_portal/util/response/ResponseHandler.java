package com.github.news_portal.util.response;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {

    public static ResponseEntity<Map<String, Object>> handleErrResponse(Exception e) {
        Map<String, Object> body = new HashMap<>();
        HttpStatus status;
        String errorMessage;

        if (e instanceof DataIntegrityViolationException && e.getCause() instanceof SQLException sqlEx) {
            int errorCode = sqlEx.getErrorCode();

            switch (errorCode) {
                case 1062 -> {
                    errorMessage = "Duplicate entry for one or more unique fields";
                    status = HttpStatus.CONFLICT;
                }
                case 1452 -> {
                    errorMessage = "A foreign key constraint fails";
                    status = HttpStatus.FAILED_DEPENDENCY;
                }
                case 1406 -> {
                    errorMessage = "Input exceeds complexity";
                    status = HttpStatus.PAYLOAD_TOO_LARGE;
                }
                default -> {
                    errorMessage = "SQL Exception";
                    status = HttpStatus.INTERNAL_SERVER_ERROR;
                }
            }
        } else {
            errorMessage = "Missing or invalid input type";
            status = HttpStatus.BAD_REQUEST;
        }

        body.put("err", status.value());
        body.put("msg", errorMessage);
        return new ResponseEntity<>(body, status);
    }

    public static ResponseEntity<Map<String, Object>> buildErrResponse(String message,HttpStatus status) {
        Map<String, Object> body = new HashMap<>();
        body.put("err", status.value());
        body.put("msg", message);
        return new ResponseEntity<>(body, status);
    }



    public static ResponseEntity<Map<String, Object>> LogErrResponse(Exception e) {
        Map<String, Object> body = new HashMap<>();
        HttpStatus status = HttpStatus.BAD_REQUEST;
        String errorMessage;

        if (e instanceof DataIntegrityViolationException && e.getCause() instanceof SQLException sqlEx) {
            int errorCode = sqlEx.getErrorCode();

            switch (errorCode) {
                case 1062 -> {
                    errorMessage = "Duplicate entry for one or more unique fields - " + sqlEx.getMessage();
                    status = HttpStatus.CONFLICT;
                }
                case 1452 -> {
                    errorMessage = "A foreign key constraint fails - " + sqlEx.getMessage();
                    status = HttpStatus.FAILED_DEPENDENCY;
                }
                case 1406 -> {
                    errorMessage = "Input exceeds complexity - " + sqlEx.getMessage();
                    status = HttpStatus.PAYLOAD_TOO_LARGE;
                }
                default -> {
                    errorMessage = "SQL Exception - " + sqlEx.getMessage();
                    status = HttpStatus.INTERNAL_SERVER_ERROR;
                }
            }
        } else {
            errorMessage = "An unexpected error occurred - " + e.getMessage();
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }

        body.put("err", status.value());
        body.put("msg", errorMessage);
        return new ResponseEntity<>(body, status);
    }



}
