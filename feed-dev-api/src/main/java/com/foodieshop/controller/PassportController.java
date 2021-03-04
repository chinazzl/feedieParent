package com.foodieshop.controller;

import com.foodieshop.bo.UserBo;
import com.foodieshop.pojo.Users;
import com.foodieshop.service.UserService;
import com.imooc.utils.CookieUtils;
import com.imooc.utils.IMOOCJSONResult;
import com.imooc.utils.JsonUtils;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: zhang zhao lin
 * @Description:
 * @Date:Create：in 2021/3/3 15:39
 * @Modified By：
 * 用于 注册登陆 以及 登录校验
 */
@RestController
@RequestMapping("/passport")
public class PassportController {

    @Autowired
    private UserService userService;

    /**
     * 校验是否已存在用户名
     *
     * @param userName
     * @return
     */
    @ApiOperation(value = "用户名是否存在", notes = "用户名是否存在", httpMethod = "GET")
    @RequestMapping("/isRegistered")
    public IMOOCJSONResult userNameRegisted(@RequestParam String userName) {
        if (StringUtils.isBlank(userName)) {
            return IMOOCJSONResult.errorMsg("输入用户名不允许为空");
        }
        if (userService.isRegisteredUser(userName)) {
            return IMOOCJSONResult.errorMsg("输入用户名已存在，请重新输入");
        }

        return IMOOCJSONResult.ok();
    }

    /**
     * 步骤
     * 1. 判断用户名称和密码不能为空
     * 2. 密码长度不能少于6位
     * 3. 判断两次密码输入是否一致
     *
     * @param userBo
     * @return
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public IMOOCJSONResult register(@RequestBody @Validated UserBo userBo,
                                    HttpServletRequest request, HttpServletResponse response) {
        String userName = userBo.getUsername();
        if (!userBo.getPassword().equals(userBo.getConfirmPassword())) {
            return IMOOCJSONResult.errorMsg("输入密码不一致");
        }

        if (userService.isRegisteredUser(userName)) {
            return IMOOCJSONResult.errorMsg("用户名已存在，请重新输入");
        }
        Users users = userService.insertUser(userBo);

        String userJson = JsonUtils.objectToJson(users);
        CookieUtils.setCookie(request, response, "user", userJson, true);

        setUserNull(users);

        return IMOOCJSONResult.ok(users);
    }

    @PostMapping("/login")
    public IMOOCJSONResult login(@RequestBody @Validated UserBo userBo,
                                 HttpServletRequest request, HttpServletResponse response) {
        Users users = userService.loginUser(userBo);
        if (users == null) {
            return IMOOCJSONResult.errorMsg("用户名或密码错误");
        }
        String userJson = JsonUtils.objectToJson(users);
        CookieUtils.setCookie(request, response, "user", userJson, true);

        setUserNull(users);
        return IMOOCJSONResult.ok(users);
    }

    private void setUserNull(Users userResult) {
        userResult.setPassword(null);
        userResult.setMobile(null);
        userResult.setEmail(null);
        userResult.setCreatedTime(null);
        userResult.setUpdatedTime(null);
        userResult.setBirthday(null);
    }

}
