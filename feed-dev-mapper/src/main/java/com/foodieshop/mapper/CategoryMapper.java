package com.foodieshop.mapper;

import com.foodieshop.my.mapper.MyMapper;
import com.foodieshop.pojo.Category;
import com.foodieshop.vo.CategoryVo;
import com.foodieshop.vo.SubCateItemVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface CategoryMapper extends MyMapper<Category> {

    List<CategoryVo> querySubCategoriesByRootId(Integer pid);

    /**
     * 根据父级rootId，查询最新六个商品信息
     */
    List<SubCateItemVo> getSubCateItemsByRootId(@Param("paraMap") Map<String, Object> param);
}