package com.lucifer.advice;


import com.lucifer.exception.AwardException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

/**
 * Created by liufx on 15/12/16.
 */
@ControllerAdvice
public class RestControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    ResponseEntity<?> handleControllerException(HttpServletRequest request, Exception ex, HttpServletResponse response) throws UnsupportedEncodingException {

        //ex.printStackTrace();
        logger.error("advice catch exception ",ex);
        HttpStatus status = HttpStatus.valueOf(500);
        response.setHeader("X-Err-Message", URLEncoder.encode(ex.getMessage(), "utf-8"));
        return new ResponseEntity<>(new ExceptionType(status.value(),request, ex), status);
    }

    public class ExceptionType extends HashMap{
        ExceptionType (Integer status, HttpServletRequest request, Exception ex){
            this.put("status",status);
            this.put("success",false);
            this.put("exception",ex.getClass().getName());
            this.put("message",ex.getMessage());

            this.put("detail",ex.getStackTrace()[0].toString());
            this.put("path",request.getContextPath()+request.getServletPath());
            this.put("url",request.getRequestURL());
            this.put("timestamp", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        }
    }


    @ExceptionHandler(AwardException.class)
    @ResponseBody
    ResponseEntity<?> handleControllerAwardException(HttpServletRequest request, AwardException ex, HttpServletResponse response) throws UnsupportedEncodingException {

        //ex.printStackTrace();
        logger.error("advice catch AwardException ",ex);
        HttpStatus status = HttpStatus.valueOf(403);
        response.setHeader("X-Err-Message", URLEncoder.encode(ex.getMessage(), "utf-8"));
        return new ResponseEntity<>(new AwardExceptionType(status.value(),request, ex), status);
    }

    public class AwardExceptionType extends HashMap{
        AwardExceptionType (Integer status, HttpServletRequest request, Exception ex){
            this.put("status",status);
            this.put("success",false);
            this.put("exception",ex.getClass().getName());
            this.put("message",ex.getMessage());

            this.put("detail",ex.getStackTrace()[0].toString());
            this.put("path",request.getContextPath()+request.getServletPath());
            this.put("url",request.getRequestURL());
            this.put("timestamp", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        }
    }




}
