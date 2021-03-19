package com.foodieshop.mapper;

import com.foodieshop.my.mapper.MyMapper;
import com.foodieshop.pojo.ItemsComments;
import com.foodieshop.vo.CommentRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ItemsCommentsMapper extends MyMapper<ItemsComments> {

    List<CommentRecord> queryCommentsByItemId(@Param("paramMap") Map<String, Object> map);

}