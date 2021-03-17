package com.foodieshop.controller;

import com.foodieshop.pojo.Items;
import com.foodieshop.pojo.ItemsImg;
import com.foodieshop.pojo.ItemsParam;
import com.foodieshop.pojo.ItemsSpec;
import com.foodieshop.service.ItemService;
import com.foodieshop.vo.ItemInfoVo;
import com.imooc.utils.IMOOCJSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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
public class ItemController {

    @Autowired
    private ItemService itemService;

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
}
