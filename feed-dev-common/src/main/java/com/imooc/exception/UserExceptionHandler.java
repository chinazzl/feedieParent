package com.imooc.exception;

import com.imooc.utils.IMOOCJSONResult;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Author: zhang zhao lin
 * @Description:
 * @Date:Create：in 2021/3/3 16:24
 * @Modified By：
 */
@RestControllerAdvice
public class UserExceptionHandler {

    // 用户注册校验
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public IMOOCJSONResult handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        BindingResult bindingResult = ex.getBindingResult();
        return IMOOCJSONResult.errorException(bindingResult.getFieldError().getDefaultMessage());
    }
}
