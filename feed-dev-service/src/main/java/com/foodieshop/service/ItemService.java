package com.foodieshop.service;

import com.foodieshop.pojo.Items;
import com.foodieshop.pojo.ItemsImg;
import com.foodieshop.pojo.ItemsParam;
import com.foodieshop.pojo.ItemsSpec;
import com.foodieshop.vo.CommentRecord;
import com.foodieshop.vo.ItemLevelCommentVo;
import com.imooc.utils.PagedGridResult;

import java.util.List;

/**
 * @Author: zhang zhao lin
 * @Description:
 * @Date:Create：in 2021/3/16 22:48
 * @Modified By：
 * 查询商品详情页
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

    /**
     * 根据商品Id 进行查询商品的评价
     */
    ItemLevelCommentVo queryCommentsByLevel(String itemId);

    /**
     * 根据商品ID 查询 商品评价
     */
    PagedGridResult queryItemCommentsByItemId(String itemId, Integer level, Integer page, Integer pageSize);

    /**
     * 根据 商品名称模糊查询 商品信息并分页处理
     * @author zhang zhao lin
     * @date 2021/3/21 13:51
     * @param itemName
     * @param sort
     * @param page
     * @param pageSize
     * @return com.imooc.utils.PagedGridResult
     */
    PagedGridResult queryItemInfoByItemName(String itemName,String sort,Integer page,Integer pageSize);
}
