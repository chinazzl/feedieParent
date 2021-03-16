package com.foodieshop.service.impl;

import com.foodieshop.mapper.CategoryMapper;
import com.foodieshop.pojo.Category;
import com.foodieshop.service.CategoryService;
import com.foodieshop.vo.CategoryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @Author: zhang zhao lin
 * @Description:
 * @Date:Create：in 2021/3/13 0:13
 * @Modified By：
 */
@Service("CategoryService")
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Transactional(propagation = Propagation.SUPPORTS,rollbackFor = RuntimeException.class)
    @Override
    public List<Category> queryAllCategoryLevelRoot() {
        Example example = new Example(Category.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("type","1");
        return categoryMapper.selectByExample(example);
    }

    /**
     * 根据父级id查询子id
     * @param pid
     * @return
     */
    @Transactional(propagation = Propagation.SUPPORTS,rollbackFor = RuntimeException.class)
    @Override
    public List<CategoryVo> queryChildCategoryVoByRootId(Integer pid) {
        return categoryMapper.querySubCategoriesByRootId(pid);
    }
}
