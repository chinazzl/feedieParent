package com.foodieshop.service.impl;

import com.foodieshop.mapper.ItemsImgMapper;
import com.foodieshop.mapper.ItemsMapper;
import com.foodieshop.mapper.ItemsParamMapper;
import com.foodieshop.mapper.ItemsSpecMapper;
import com.foodieshop.pojo.Items;
import com.foodieshop.pojo.ItemsImg;
import com.foodieshop.pojo.ItemsParam;
import com.foodieshop.pojo.ItemsSpec;
import com.foodieshop.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @Author: zhang zhao lin
 * @Description:
 * @Date:Create：in 2021/3/16 22:49
 * @Modified By：
 */
@Service("ItemService")
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemsMapper itemsMapper;

    @Autowired
    private ItemsImgMapper itemsImgMapper;

    @Autowired
    private ItemsSpecMapper itemsSpecMapper;

    @Autowired
    private ItemsParamMapper itemsParamMapper;

    /**
     * 查询商品
     *
     * @param itemId
     */
    @Override
    public Items queryItemsById(String itemId) {
        Example example = new Example(Items.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id",itemId);
        return itemsMapper.selectOneByExample(example);
    }

    /**
     * 根据商品id查询商品图片列表
     *
     * @param itemId
     */
    @Override
    public List<ItemsImg> queryItemImgList(String itemId) {
        Example example = new Example(ItemsImg.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("itemId",itemId);
        return itemsImgMapper.selectByExample(example);

    }

    /**
     * 根据商品id 查询商品规格
     *
     * @param itemId
     */
    @Override
    public List<ItemsSpec> queryItemsSpecList(String itemId) {
        Example example = new Example(ItemsSpec.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("itemId",itemId);
        return itemsSpecMapper.selectByExample(example);
    }

    /**
     * 根据商品id查询商品参数
     *
     * @param itemId
     */
    @Override
    public ItemsParam queryItemParam(String itemId) {
        Example example = new Example(ItemsParam.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("itemId",itemId);
        return itemsParamMapper.selectOneByExample(example);
    }
}
