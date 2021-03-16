package com.foodieshop.service;

import com.foodieshop.vo.SubCateItemVo;

import java.util.List;

/**
 * @Author: zhang zhao lin
 * @Description:
 * @Date:Create：in 2021/3/14 15:03
 * @Modified By：
 * 根据 商品父级id，展示二级商品信息
 */
public interface SixNewItemService {

    List<SubCateItemVo> getSixNewItemList(Integer catRootId);

}
