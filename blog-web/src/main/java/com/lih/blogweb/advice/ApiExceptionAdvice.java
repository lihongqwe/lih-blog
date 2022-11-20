package com.lih.blogweb.advice;

import com.baomidou.kaptcha.exception.KaptchaIncorrectException;
import com.baomidou.kaptcha.exception.KaptchaNotFoundException;
import com.baomidou.kaptcha.exception.KaptchaTimeoutException;
import com.lih.blogcommon.exception.ApiException;
import com.lih.blogsystem.dto.ErrorDTO;
import org.springframework.data.redis.RedisConnectionFailureException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.validation.BindException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;


@RestControllerAdvice
public class ApiExceptionAdvice {

    @ExceptionHandler(value = Exception.class)
    //由ApiException接管Service异常和系统异常
    public ResponseEntity<ErrorDTO> exception(Exception exception, HttpServletResponse response){
        ErrorDTO errorDTO = new ErrorDTO();
        if(exception instanceof ApiException){
            ApiException apiException = (ApiException) exception;
            errorDTO.setMessage(apiException.getErrMsg());
            errorDTO.setHttpCode(apiException.getHttpCode());
        }else if(exception instanceof AccessDeniedException){
            errorDTO.setMessage("无权限访问");
            errorDTO.setHttpCode(403);
        }else if (exception instanceof NoHandlerFoundException) {
            errorDTO.setMessage("404 Not Found");
            errorDTO.setHttpCode(404);
        }else if (exception instanceof HttpRequestMethodNotSupportedException) {
            errorDTO.setMessage("请求方法不支持");
            errorDTO.setHttpCode(405);
        }else if (exception instanceof BindException) {
            errorDTO.setMessage("请求格式错误");
            errorDTO.setHttpCode(400);
        }else if (exception instanceof ConstraintViolationException) {
            errorDTO.setMessage("请求格式错误");
            errorDTO.setHttpCode(400);
        }else if (exception instanceof MissingServletRequestParameterException) {
            errorDTO.setMessage("请求格式错误");
            errorDTO.setHttpCode(400);
        }else if(exception instanceof HttpMessageNotReadableException) {
            errorDTO.setMessage("请求格式错误");
            errorDTO.setHttpCode(400);
        }else if(exception instanceof RedisConnectionFailureException) {
            errorDTO.setMessage("Redis异常");
            errorDTO.setHttpCode(500);
        }else if(exception instanceof KaptchaIncorrectException || exception instanceof KaptchaNotFoundException) {
            errorDTO.setMessage("验证码错误");
            errorDTO.setHttpCode(200);
        } else if (exception instanceof KaptchaTimeoutException) {
            errorDTO.setMessage("验证码已过期");
            errorDTO.setHttpCode(200);
        } else{
            errorDTO.setMessage("未知系统错误");
            errorDTO.setHttpCode(500);
            exception.printStackTrace();
        }

        return new ResponseEntity<>(errorDTO,HttpStatus.valueOf(errorDTO.getHttpCode()));
    }

}
