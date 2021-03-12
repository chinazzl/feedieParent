package com.foodieshop.service.impl;

import com.foodieshop.mapper.CarouselMapper;
import com.foodieshop.pojo.Carousel;
import com.foodieshop.service.CarouselService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @Author: zhang zhao lin
 * @Description:
 * @Date:Create：in 2021/3/11 22:29
 * @Modified By：
 * 轮播图
 */
@Service("CarouselService")
public class CarouselServiceImpl implements CarouselService {

    @Autowired
    private CarouselMapper carouselMapper;

    /**
     * 轮播图 展示
     * @param isShow
     * @return
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<Carousel> queryAll(Integer isShow) {
        Example example = new Example(Carousel.class);
        example.orderBy("sort").desc();
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("isShow", isShow);
        return carouselMapper.selectByExample(example);
    }
}
