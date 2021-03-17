package com.foodieshop.service;

import com.foodieshop.pojo.Items;
import com.foodieshop.pojo.ItemsImg;
import com.foodieshop.pojo.ItemsParam;
import com.foodieshop.pojo.ItemsSpec;

import java.util.List;

/**
 * @Author: zhang zhao lin
 * @Description:
 * @Date:Create：in 2021/3/16 22:48
 * @Modified By：
 *  查询商品详情页
 */
public interface ItemService {

    /**
     * 查询商品
     */
    Items queryItemsById(String itemId);
    /**
     * 根据商品id查询商品图片列表
     */
    List<ItemsImg> queryItemImgList(String itemId);

    /**
     * 根据商品id 查询商品规格
     */
    List<ItemsSpec> queryItemsSpecList(String itemId);

    /**
     * 根据商品id查询商品参数
     */
    ItemsParam queryItemParam(String itemId);
}
