package com.foodieshop.service.impl;

import com.foodieshop.mapper.CategoryMapper;
import com.foodieshop.service.SixNewItemService;
import com.foodieshop.vo.SubCateItemVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: zhang zhao lin
 * @Description:
 * @Date:Create：in 2021/3/14 15:16
 * @Modified By：
 */
@Service
public class ItemSerivceImpl implements SixNewItemService {
    @Autowired
    private CategoryMapper categoryMapper;

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<SubCateItemVo> getSixNewItemList(Integer catRootId) {
        Map<String, Object> paraMap = new HashMap<>();
        paraMap.put("catRootId", catRootId);
        return categoryMapper.getSubCateItemsByRootId(paraMap);
    }
}
