package com.foodieshop.vo;

/**
 * @Author: zhang zhao lin
 * @Description:
 * @Date:Create：in 2021/3/14 14:56
 * @Modified By：
 * 展示首页下方六个最新商品
 */
public class SixNewItem {
    private String itemName;

    private String itemId;

    private String itemUrl;

    private String createdTime;

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItemUrl() {
        return itemUrl;
    }

    public void setItemUrl(String itemUrl) {
        this.itemUrl = itemUrl;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }
}
