package com.foodieshop.controller;

import com.foodieshop.pojo.Items;
import com.foodieshop.pojo.ItemsImg;
import com.foodieshop.pojo.ItemsParam;
import com.foodieshop.pojo.ItemsSpec;
import com.foodieshop.service.ItemService;
import com.foodieshop.vo.CommentRecord;
import com.foodieshop.vo.ItemInfoVo;
import com.foodieshop.vo.ItemLevelCommentVo;
import com.imooc.utils.IMOOCJSONResult;
import com.imooc.utils.PagedGridResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: zhang zhao lin
 * @Description:
 * @Date:Create：in 2021/3/16 23:01
 * @Modified By：
 * 商品详情Controller
 */
@RestController
@RequestMapping("/items")
public class ItemController extends BaseController {

    @Autowired
    private ItemService itemService;

    /**
     * 获取商品详情信息
     *
     * @param itemId
     * @return
     */
    @RequestMapping("/info/{itemId}")
    public IMOOCJSONResult queryItemInfos(@PathVariable("itemId") String itemId) {

        if (itemId == null) {
            return IMOOCJSONResult.errorMsg(null);
        }
        ItemInfoVo itemInfoVo = new ItemInfoVo();
        Items items = itemService.queryItemsById(itemId);
        List<ItemsImg> itemsImgs = itemService.queryItemImgList(itemId);
        ItemsParam itemsParam = itemService.queryItemParam(itemId);
        List<ItemsSpec> itemsSpecs = itemService.queryItemsSpecList(itemId);

        itemInfoVo.setItem(items);
        itemInfoVo.setItemImgList(itemsImgs);
        itemInfoVo.setItemParams(itemsParam);
        itemInfoVo.setItemSpecList(itemsSpecs);

        return IMOOCJSONResult.ok(itemInfoVo);
    }

    /**
     * 获取 评论 个数
     *
     * @param itemId
     * @return
     */
    @RequestMapping("/commentLevel")
    public IMOOCJSONResult queryItemCommentByItemId(@RequestParam("itemId") String itemId) {
        ItemLevelCommentVo levelCommentVo = itemService.queryCommentsByLevel(itemId);
        return IMOOCJSONResult.ok(levelCommentVo);
    }

    /**
     * 查询 商品各个等级的评论信息
     *
     * @param itemId   商品id
     * @param level    商品的等级 1 好评 2 中评 3 差评
     * @param page     当前页
     * @param pageSize 每页显示条数
     * @return
     */
    @RequestMapping("/comments")
    public IMOOCJSONResult getComments(@RequestParam("itemId") String itemId, @RequestParam("level") Integer level,
                                       @RequestParam("page") Integer page, @RequestParam("pageSize") Integer pageSize) {
        if (itemId == null) {
            return IMOOCJSONResult.errorMsg(null);
        }
        if (pageSize == null) {
            pageSize = PAGE_DEFAULT_SIZE;
        }
        if (page == null) {
            page = PAGE_DEFAULT;
        }
        PagedGridResult commentRecords = itemService.queryItemCommentsByItemId(itemId, level, page, pageSize);
        return IMOOCJSONResult.ok(commentRecords);
    }

}
