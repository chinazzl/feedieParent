package com.foodieshop.controller;

import com.foodieshop.pojo.Carousel;
import com.foodieshop.pojo.Category;
import com.foodieshop.service.CarouselService;
import com.foodieshop.service.CategoryService;
import com.foodieshop.service.SixNewItemService;
import com.foodieshop.vo.CategoryVo;
import com.foodieshop.vo.SubCateItemVo;
import com.imooc.enums.YesOrNo;
import com.imooc.utils.IMOOCJSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: zhang zhao lin
 * @Description:
 * @Date:Create：in 2021/3/11 22:41
 * @Modified By：
 */
@RestController
@RequestMapping("/index")
public class IndexController {

    @Autowired
    private CarouselService carouselService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private SixNewItemService sixNewItemService;

    /**
     * 轮播图展示
     *
     * @return
     */
    @RequestMapping("/carousel")
    public IMOOCJSONResult getCarousel() {
        List<Carousel> carousels = carouselService.queryAll(YesOrNo.YES.type);
        return IMOOCJSONResult.ok(carousels);
    }

    /**
     * 1. 根据type 展示大类
     * 2. 根据大类展示子类，并实现懒加载
     *
     * @return
     */
    @RequestMapping("/cats")
    public IMOOCJSONResult getCategoryLevelRoot() {
        List<Category> categories = categoryService.queryAllCategoryLevelRoot();
        return IMOOCJSONResult.ok(categories);
    }

    /**
     * 根据父级id查询子项目
     */
    @RequestMapping("/subCat/{pid}")
    public IMOOCJSONResult getSubCategoryByPid(@PathVariable("pid") Integer pid) {
        if (pid == null) {
            return IMOOCJSONResult.errorMsg("pid is not null");
        }
        List<CategoryVo> categoryVos = categoryService.queryChildCategoryVoByRootId(pid);
        return IMOOCJSONResult.ok(categoryVos);
    }

    @RequestMapping("/sixNewItems/{rootCatId}")
    public IMOOCJSONResult getSixNewItems(@PathVariable("rootCatId") Integer rootCatId) {
        if (rootCatId == null) {
            return IMOOCJSONResult.errorMsg("rootCatId is not null");
        }
        List<SubCateItemVo> sixNewItemList = sixNewItemService.getSixNewItemList(rootCatId);
        return IMOOCJSONResult.ok(sixNewItemList);
    }
}
