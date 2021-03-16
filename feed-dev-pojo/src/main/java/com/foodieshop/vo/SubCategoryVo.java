package com.foodieshop.vo;

/**
 * @Author: zhang zhao lin
 * @Description:
 * @Date:Create：in 2021/3/13 0:52
 * @Modified By：
 */
public class SubCategoryVo {

    private Integer subId;

    private String subName;

    private Integer subType;

    private Integer subFatherId;

    public Integer getSubId() {
        return subId;
    }

    public void setSubId(Integer subId) {
        this.subId = subId;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    public Integer getSubType() {
        return subType;
    }

    public void setSubType(Integer subType) {
        this.subType = subType;
    }

    public Integer getSubFatherId() {
        return subFatherId;
    }

    public void setSubFatherId(Integer subFatherId) {
        this.subFatherId = subFatherId;
    }
}
