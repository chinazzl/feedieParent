package com.foodieshop.bo;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * @Author: zhang zhao lin
 * @Description:
 * @Date:Create：in 2021/3/3 14:44
 * @Modified By：
 * 前端向后端传参 实体
 */
public class UserBo {

    @NotNull(message = "录入用户名不允许为空")
    private String username;

    @NotNull(message = "录入密码不允许为空")
    @Length(min = 6,message = "最小长度不能小于6")
    private String password;

    private String confirmPassword;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

}
