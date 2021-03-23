package com.foodieshop.mapper;

import com.foodieshop.my.mapper.MyMapper;
import com.foodieshop.pojo.ItemsSpec;
import com.foodieshop.vo.ShopCartItemVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ItemsSpecMapper extends MyMapper<ItemsSpec> {

    List<ShopCartItemVo> queryShopCartItemBySpecId(@Param("paramList") List<String> specIds);
}