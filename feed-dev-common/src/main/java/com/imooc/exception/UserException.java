package com.imooc.exception;

import java.sql.SQLException;

/**
 * @Author: zhang zhao lin
 * @Description:
 * @Date:Create：in 2021/3/4 15:17
 * @Modified By：
 */
public class UserException extends RuntimeException {

    public UserException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserException(String message) {
        super(message);
    }
}
