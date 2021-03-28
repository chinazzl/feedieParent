package com.foodieshop.service;


import com.foodieshop.pojo.UserAddress;

import java.util.List;

public interface UserItemAddressService {

    /**
     * 根据用户名Id查询用户设置地址信息
     * @author zhang zhao lin
     * @date 2021/3/27 13:57
     * @param userId 
     * @return java.util.List<com.foodieshop.pojo.UserAddress>
     */
    List<UserAddress> getUserAddressByUserId(String userId);
}
