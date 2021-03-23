package com.foodieshop.controller;

import com.foodieshop.bo.ShopCartItemBo;
import com.imooc.utils.IMOOCJSONResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author zhang zhao lin
 * @date 2021年03月22日 22:47
 * 商品购物车 controller
 */
@RestController
@RequestMapping("/shopcart")
public class ShopCartController {

    @PostMapping(value ="/add")
    public IMOOCJSONResult addShopCart(@RequestParam("userId") String userId,
                                       @RequestBody ShopCartItemBo shopCartItemBo,
                                       HttpServletRequest request,
                                       HttpServletResponse response) {

        System.out.println(shopCartItemBo);

        // TODO 前端用户在登录的情况下，添加商品到购物车，会同时在后端同步购物车到redis缓存

        return IMOOCJSONResult.ok();

    }
}
