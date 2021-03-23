package com.foodieshop.vo;

/**
 * @author zhang zhao lin
 * @date 2021年03月22日 22:31
 * 商品购物车 返回前端
 */
public class ShopCartItemVo {

    //商品id
    private String itemId;

    //商品图片url
    private String itemImgUrl;

    // 商品名称
    private String itemName;

    // 商品规格Id
    private String specId;

    // 商品规格名称
    private String specName;

    //促销价
    private Integer priceDiscount;

    //原价
    private Integer priceNormal;


    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItemImgUrl() {
        return itemImgUrl;
    }

    public void setItemImgUrl(String itemImgUrl) {
        this.itemImgUrl = itemImgUrl;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getSpecId() {
        return specId;
    }

    public void setSpecId(String specId) {
        this.specId = specId;
    }

    public String getSpecName() {
        return specName;
    }

    public void setSpecName(String specName) {
        this.specName = specName;
    }

    public Integer getPriceDiscount() {
        return priceDiscount;
    }

    public void setPriceDiscount(Integer priceDiscount) {
        this.priceDiscount = priceDiscount;
    }

    public Integer getPriceNormal() {
        return priceNormal;
    }

    public void setPriceNormal(Integer priceNormal) {
        this.priceNormal = priceNormal;
    }

}
