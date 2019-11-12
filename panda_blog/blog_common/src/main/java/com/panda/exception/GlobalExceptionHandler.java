package com.panda.exception;

import com.panda.common.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Mr.wl
 * @create 2019-06-23 16:44
 * @description: controller统一异常捕获
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Result validationErrorHandler(Exception e) {
        CustomException cu ;
        if (e instanceof  CustomException){
            log.error("捕获到自定义异常:{}",e.getMessage(),e);
            cu = (CustomException) e;
        }else {

            log.error("捕获到意外错误:{}", e.getMessage(), e);
            cu = new CustomException("服务器异常");
        }
        return  new Result(cu.getCode(),cu.getMessage(),null);
    }
}
