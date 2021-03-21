package com.foodieshop.mapper;

import com.foodieshop.my.mapper.MyMapper;
import com.foodieshop.pojo.Items;
import com.foodieshop.vo.SearchItemVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ItemsMapper extends MyMapper<Items> {

    List<SearchItemVo> queryItemsByItemName(@Param("paramsMap")Map<String,Object> param);

}