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
 *
 * @author zhang zhao lin
 * @date 2021/3/21 13:45
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
