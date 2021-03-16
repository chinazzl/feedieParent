package com.foodieshop.service;

import com.foodieshop.pojo.Category;
import com.foodieshop.vo.CategoryVo;

import java.util.List;

/**
 * @Author: zhang zhao lin
 * @Description:
 * @Date:Create：in 2021/3/13 0:11
 * @Modified By：
 *  商品分分类service
 */
public interface CategoryService {

    // 查询父级分类
    List<Category> queryAllCategoryLevelRoot();

    List<CategoryVo> queryChildCategoryVoByRootId(Integer pid);
}
