package com.foodieshop.service;

import com.foodieshop.bo.UserBo;
import com.foodieshop.pojo.Users;

/**
 * @Author: zhang zhao lin
 * @Description:
 * @Date:Create：in 2021/3/3 14:28
 * @Modified By：
 *  用户登陆/注册 校验
 */
public interface UserService {

    /**
     * @param userName
     * @return
     */
    boolean isRegisteredUser(String userName);

    Users insertUser(UserBo userBo);

    Users loginUser(UserBo userBo);
}
