package com.imooc.exception;

import com.imooc.utils.IMOOCJSONResult;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import com.mysql.jdbc.exceptions.jdbc4.MySQLNonTransientException;
import org.apache.catalina.User;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

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

    @ExceptionHandler(value = {
            SQLException.class
    })
    public IMOOCJSONResult handSqlException(SQLException ex) {
        System.out.println(ex.getMessage());
        if (ex instanceof SQLIntegrityConstraintViolationException) {
            return IMOOCJSONResult.errorException("数据库操作异常！");
        }
        return IMOOCJSONResult.errorException("数据异常");
    }

    @ExceptionHandler(value = {
            UserException.class
    })
    public IMOOCJSONResult handleUserException(Exception ex) {
        return IMOOCJSONResult.errorException(ex.getMessage());
    }
}
