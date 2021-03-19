package com.foodieshop.vo;

/**
 * @Author: zhang zhao lin
 * @Description:
 * @Date:Create：in 2021/3/17 22:15
 * @Modified By：
 * 商品 评价vo
 */
public class ItemLevelCommentVo {
    //商品评价总数
    private Integer totalCounts;

    // 商品好评
    private Integer goodCounts;

    // 商品默认评价
    private Integer normalCounts;

    // 商品差评评价
    private Integer badCounts;

    public Integer getTotalCounts() {
        return totalCounts;
    }

    public void setTotalCounts(Integer totalCounts) {
        this.totalCounts = totalCounts;
    }

    public Integer getGoodCounts() {
        return goodCounts;
    }

    public void setGoodCounts(Integer goodCounts) {
        this.goodCounts = goodCounts;
    }

    public Integer getNormalCounts() {
        return normalCounts;
    }

    public void setNormalCounts(Integer normalCounts) {
        this.normalCounts = normalCounts;
    }

    public Integer getBadCounts() {
        return badCounts;
    }

    public void setBadCounts(Integer badCounts) {
        this.badCounts = badCounts;
    }
}
