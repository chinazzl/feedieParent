package com.foodieshop.vo;

import java.util.Date;

/**
 * @Author: zhang zhao lin
 * @Description:
 * @Date:Create：in 2021/3/18 22:24
 * @Modified By：
 *
 *  评论详情
 */
public class CommentRecord {

    // 用户头像
    private String userFace;

    // 用户昵称
    private String nickName;

    //创建时间
    private Date createdTime;

    //评论内容
    private String content;

    // 规格名字
    private String specName;

    public String getUserFace() {
        return userFace;
    }

    public void setUserFace(String userFace) {
        this.userFace = userFace;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSpecName() {
        return specName;
    }

    public void setSpecName(String specName) {
        this.specName = specName;
    }
}
