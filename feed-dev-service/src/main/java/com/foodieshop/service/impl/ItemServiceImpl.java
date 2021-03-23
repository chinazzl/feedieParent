package com.foodieshop.service.impl;

import com.foodieshop.mapper.*;
import com.foodieshop.pojo.*;
import com.foodieshop.service.ItemService;
import com.foodieshop.vo.CommentRecord;
import com.foodieshop.vo.ItemLevelCommentVo;
import com.foodieshop.vo.SearchItemVo;
import com.foodieshop.vo.ShopCartItemVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.imooc.enums.CommentLevel;
import com.imooc.utils.DesensitizationUtil;
import com.imooc.utils.PagedGridResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Autowired
    private ItemsCommentsMapper itemCommentsMapper;

    /**
     * 查询商品
     *
     * @param itemId
     */
    @Override
    public Items queryItemsById(String itemId) {
        Example example = new Example(Items.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id", itemId);
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
        criteria.andEqualTo("itemId", itemId);
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
        criteria.andEqualTo("itemId", itemId);
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
        criteria.andEqualTo("itemId", itemId);
        return itemsParamMapper.selectOneByExample(example);
    }

    /**
     * 根据商品Id 进行查询商品的评价
     *
     * @param itemId 商品id
     */
    @Override
    public ItemLevelCommentVo queryCommentsByLevel(String itemId) {
        // 获取好评数量
        ItemLevelCommentVo levelCommentVo = new ItemLevelCommentVo();
        Integer goodComment = getCommentCount(itemId, CommentLevel.GOOD.type);
        Integer normalComment = getCommentCount(itemId, CommentLevel.NORMAL.type);
        Integer badComment = getCommentCount(itemId, CommentLevel.BAD.type);
        Integer totalComment = goodComment + normalComment + badComment;
        levelCommentVo.setTotalCounts(totalComment);
        levelCommentVo.setBadCounts(badComment);
        levelCommentVo.setGoodCounts(goodComment);
        levelCommentVo.setNormalCounts(normalComment);

        return levelCommentVo;
    }

    /**
     * 根据商品ID 查询 商品评价
     *
     * @param itemId
     * @param page
     * @param pageSize
     */
    @Override
    public PagedGridResult queryItemCommentsByItemId(String itemId, Integer level, Integer page, Integer pageSize) {
        Map<String, Object> paramMap = new HashMap<>();
        PageHelper.startPage(page, pageSize);
        paramMap.put("itemId", itemId);
        paramMap.put("level", level);
        List<CommentRecord> list = itemCommentsMapper.queryCommentsByItemId(paramMap);
        for (CommentRecord commentRecord : list) {
            if (commentRecord.getNickName() != null) {
                String nickName = DesensitizationUtil.commonDisplay(commentRecord.getNickName());
                commentRecord.setNickName(nickName);
            }
        }
        return getCommentPaged(list, page);
    }

    /**
     * 根据 商品名称模糊查询 商品信息并分页处理
     *
     * @param itemName
     * @param sort
     * @param page
     * @param pageSize
     * @return com.imooc.utils.PagedGridResult
     * @author zhang zhao lin
     * @date 2021/3/21 13:51
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public PagedGridResult queryItemInfoByItemName(String itemName, String sort, Integer page, Integer pageSize) {
        Map<String, Object> params = new HashMap<>();
        params.put("itemName", itemName);
        params.put("sort", sort);
        PageHelper.startPage(page, pageSize);
        List<SearchItemVo> list = itemsMapper.queryItemsByItemName(params);
        return getCommentPaged(list, page);
    }

    /**
     * 根据cookie中的 规格id，刷新购物车中的规格信息
     *
     * @param specIds
     * @return java.util.List<com.foodieshop.vo.ShopCartItemVo>
     * @author zhang zhao lin
     * @date 2021/3/23 22:40
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<ShopCartItemVo> queryShopCartItemBySpecId(String specIds) {
        String[] specId = specIds.split(",");
        List<String> specIdList = Arrays.asList(specId);
        return itemsSpecMapper.queryShopCartItemBySpecId(specIdList);
    }

    private PagedGridResult getCommentPaged(List<?> list, Integer page) {
        PageInfo pageInfo = new PageInfo<>(list);
        PagedGridResult pagedGridResult = new PagedGridResult();
        pagedGridResult.setPage(page);
        pagedGridResult.setRows(list);
        //设置总页数
        pagedGridResult.setTotal(pageInfo.getPages());
        //设置总记录数
        pagedGridResult.setRecords(pageInfo.getTotal());
        return pagedGridResult;
    }


    /**
     * 动态获取评价数量
     *
     * @param itemId 商品id
     * @param level  1 好评 2 默认 3 差评
     * @return
     */
    private Integer getCommentCount(String itemId, Integer level) {
        ItemsComments itemsComments = new ItemsComments();
        itemsComments.setItemId(itemId);
        if (level != null) {
            itemsComments.setCommentLevel(level);
        }
        return itemCommentsMapper.selectCount(itemsComments);
    }
}
