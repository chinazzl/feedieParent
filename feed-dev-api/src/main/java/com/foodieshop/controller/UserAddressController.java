package com.foodieshop.controller;

import com.foodieshop.pojo.UserAddress;
import com.foodieshop.service.UserItemAddressService;
import com.imooc.utils.IMOOCJSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zhang zhao lin
 * @date 2021年03月27日 14:04
 */
@RestController
@RequestMapping(value = "/address")
public class UserAddressController {

    @Autowired
    private UserItemAddressService userItemAddressService;


    @PostMapping(value = "/list")
    public IMOOCJSONResult queryUserAddressByuserId(@RequestParam("userId") String userId) {
        if (userId == null) {
            return IMOOCJSONResult.errorMsg("该用户不存在");
        }
        List<UserAddress> list = userItemAddressService.getUserAddressByUserId(userId);
        return IMOOCJSONResult.ok(list);
    }
}
