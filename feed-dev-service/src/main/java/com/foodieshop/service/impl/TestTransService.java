package com.foodieshop.service.impl;

/**
 * @Author: zhang zhao lin
 * @Description:
 * @Date:Create：in 2021/3/2 13:49
 * @Modified By：
 */

import com.foodieshop.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TestTransService implements ITestTransService{

    @Autowired
    private StuService stuService;

    /** 事务传播行为：
     *      REQUIRED： 使用当前的事务，如果当前没有事务，则自己新建一个事务，子方法必须运行在一个事务中，
     *                如果当前存在事务，则加入这个事务，成为一个整体。
     *      SUPPORTS: 如果当前有事务则使用事务；如果当前无事务，则不使用事务。
     *      MANDATORY:如果当前没有事务，则会抛出异常 org.springframework.transaction.IllegalTransactionStateException: No existing transaction found for transaction marked with propagation 'mandatory'
     *      REQUIRES_NEW: 如果使用当前事务，则挂起当前事务，并创建一个新事务供自己使用。
     *      NOT_SUPPORTED: 如果当前有事务，则把事务挂起，自己不使用事务去运行数据库操作。
     *      NEVER:  如果当前有事物存在，则抛出异常
     *      NESTED: 如果当前有事务，则开启子事务（嵌套事务），嵌套事务时独立提交或者回滚；
     *              如果当前没有事务，则同REQUIRED。
     *              但是如果主事务提交，则会携带子事务一起提交。
     *              如果主事务回滚，则子事务会一起回滚。相反，子事务异常，则父事务可以回滚或不会滚
     */

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void saveParent() {
        stuService.saveStu(null);
        // 使用 REQUIRES_NEW   当前事务开启，运行后面代码报异常，saveStu方法回滚，sveStu2方法创建新的事务，则不回滚成功入库
        try {
            stuService.sveStu2(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
//        int i =1/0;

    }
}
