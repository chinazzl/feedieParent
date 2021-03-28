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
    /**
     * 添加商品信息到购物车，如果用户已经登录
     *
     * @param userId
     * @param shopCartItemBo
     * @param request
     * @param response
     * @return com.imooc.utils.IMOOCJSONResult
     * @author zhang zhao lin
     * @date 2021/3/24 22:04
     */
    @PostMapping(value = "/add")
    public IMOOCJSONResult addShopCart(@RequestParam("userId") String userId,
                                       @RequestBody ShopCartItemBo shopCartItemBo,
                                       HttpServletRequest request,
                                       HttpServletResponse response) {

        System.out.println(shopCartItemBo);

        // TODO 前端用户在登录的情况下，添加商品到购物车，会同时在后端同步购物车到redis缓存

        return IMOOCJSONResult.ok();

    }

    /**
     * 如果用户已经登录,购物车中删除商品信息
     *
     * @param userId
     * @param itemSpecId
     * @param response
     * @param request
     * @return com.imooc.utils.IMOOCJSONResult
     * @author zhang zhao lin
     * @date 2021/3/24 22:03
     */
    @PostMapping("/del")
    public IMOOCJSONResult dellShopCart(@RequestParam("userId") String userId,
                                        @RequestParam("itemSpecId") String itemSpecId,
                                        HttpServletResponse response,
                                        HttpServletRequest request) {
        if (userId == null) {
            return IMOOCJSONResult.ok();
        }

        //TODO 删除购物车信息后，如果用户已经登录，则在redis中进行删除购物车商品信息

        return IMOOCJSONResult.ok();
    }

}
