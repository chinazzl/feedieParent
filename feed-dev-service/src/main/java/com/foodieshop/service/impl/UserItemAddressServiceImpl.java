package com.foodieshop.service.impl;

import com.foodieshop.mapper.UserAddressMapper;
import com.foodieshop.pojo.UserAddress;
import com.foodieshop.service.UserItemAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author zhang zhao lin
 * @date 2021年03月27日 13:57
 */
@Service("UserItemAddressService")
public class UserItemAddressServiceImpl implements UserItemAddressService {

    @Autowired
    private UserAddressMapper userAddressMapper;
    /**
     * 根据用户名Id查询用户设置地址信息
     *
     * @param userId 用户名Id
     * @return java.util.List<com.foodieshop.pojo.UserAddress>
     * @author zhang zhao lin
     * @date 2021/3/27 13:57
     */
    @Override
    public List<UserAddress> getUserAddressByUserId(String userId) {
        Example example = new Example(UserAddress.class);
        example.createCriteria().andEqualTo("userId", userId);
        return userAddressMapper.selectByExample(example);
    }
}
