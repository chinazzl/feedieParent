package com.foodieshop.controller;

import com.foodieshop.pojo.Carousel;
import com.foodieshop.service.CarouselService;
import com.imooc.enums.YesOrNo;
import com.imooc.utils.IMOOCJSONResult;
import org.springframework.beans.factory.annotation.Autowired;
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

    /**
     * 轮播图展示
     * @return
     */
    @RequestMapping("/carousel")
    public IMOOCJSONResult getCarousel() {
        List<Carousel> carousels = carouselService.queryAll(YesOrNo.YES.type);
        return IMOOCJSONResult.ok(carousels);
    }
}
