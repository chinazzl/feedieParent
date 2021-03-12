package com.foodieshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @Author: zhang zhao lin
 * @Description:
 * @Date:Create：in 2021/3/1 15:18
 * @Modified By：
 */
@SpringBootApplication
@MapperScan(basePackages = {"com.foodieshop.mapper"})
@ComponentScan(basePackages = {"com.imooc", "org.n3r.idworker","com.foodieshop"})
public class FoodieShopRunner {
    public static void main(String[] args) {
        SpringApplication.run(FoodieShopRunner.class, args);
    }
}
