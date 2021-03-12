package com.foodieshop.service;

import com.foodieshop.pojo.Carousel;

import java.util.List;

/**
 * @Author: zhang zhao lin
 * @Description:
 * @Date:Create：in 2021/3/11 21:42
 * @Modified By：
 * 轮播图
 */
public interface CarouselService {

    List<Carousel> queryAll(Integer isShow);
}
