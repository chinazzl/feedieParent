package com.foodieshop.vo;

import java.util.List;

/**
 * @Author: zhang zhao lin
 * @Description:
 * @Date:Create：in 2021/3/14 14:52
 * @Modified By：
 * 二级商品分类 展示 商品信息
 */
public class SubCateItemVo {
    private Integer rootCatId;

    private String rootCatName;

    private String slogan;

    private String bgColor;

    private String catImage;

    private List<SixNewItem> simpleItemList;

    public Integer getRootCatId() {
        return rootCatId;
    }

    public String getRootCatName() {
        return rootCatName;
    }

    public void setRootCatName(String rootCatName) {
        this.rootCatName = rootCatName;
    }

    public void setRootCatId(Integer rootCatId) {
        this.rootCatId = rootCatId;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public String getBgColor() {
        return bgColor;
    }

    public void setBgColor(String bgColor) {
        this.bgColor = bgColor;
    }

    public String getCatImage() {
        return catImage;
    }

    public void setCatImage(String catImage) {
        this.catImage = catImage;
    }

    public List<SixNewItem> getSimpleItemList() {
        return simpleItemList;
    }

    public void setSimpleItemList(List<SixNewItem> simpleItemList) {
        this.simpleItemList = simpleItemList;
    }
}
