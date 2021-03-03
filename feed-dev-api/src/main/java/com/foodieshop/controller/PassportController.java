package com.foodieshop.controller;

import com.foodieshop.bo.UserBo;
import com.foodieshop.service.UserService;
import com.imooc.utils.IMOOCJSONResult;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
     * 1. 判断用户名称和密码不能为空
     * 2. 密码长度不能少于6位
     * 3. 判断两次密码输入是否一致
     * @param userBo
     * @return
     */
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public IMOOCJSONResult register(@RequestBody @Validated UserBo userBo) {
        String userName = userBo.getUsername();
        if (userBo.getPassword().equals(userBo.getConfirmPassword())) {
            return IMOOCJSONResult.errorMsg("输入密码不一致");
        }

        if (userService.isRegisteredUser(userName)) {
            return IMOOCJSONResult.errorMsg("用户名已存在，请重新输入");
        }
        userService.insertUser(userBo);
        return IMOOCJSONResult.ok();
    }

}
