package com.foodieshop.service.impl;

import com.foodieshop.mapper.StuMapper;
import com.foodieshop.my.mapper.MyMapper;
import com.foodieshop.pojo.Stu;
import com.foodieshop.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: zhang zhao lin
 * @Description:
 * @Date:Create：in 2021/3/2 11:09
 * @Modified By：
 */
@Service
public class StuServiceImpl implements StuService {

    @Autowired
    private StuMapper myMapper;

    @Override
    public void saveStu(Stu stu) {
        Stu s = new Stu();
        s.setName("parent");
        s.setAge(20);
        myMapper.insert(s);
    }

    @Transactional(propagation = Propagation.NESTED)
    @Override
    public void sveStu2(Stu stu) {
        saveChild1();
        int i = 1/0;
        saveChild1();
    }

    public void saveChild1() {
        Stu s = new Stu();
        s.setName("chiled-1");
        s.setAge(23);
        myMapper.insert(s);
    }

    public void saveChild2() {
        Stu s = new Stu();
        s.setName("chiled-2");
        s.setAge(23);
        myMapper.insert(s);
    }
}
