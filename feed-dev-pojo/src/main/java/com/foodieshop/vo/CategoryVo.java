package com.foodieshop.vo;

import java.util.List;

/**
 * @Author: zhang zhao lin
 * @Description:
 * @Date:Create：in 2021/3/13 0:45
 * @Modified By：
 */
public class CategoryVo {
    private Integer id;

    private String name;

    private Integer type;

    private Integer fatherId;

    private List<SubCategoryVo> subCatList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public List<SubCategoryVo> getSubCatList() {
        return subCatList;
    }

    public void setSubCatList(List<SubCategoryVo> subCatList) {
        this.subCatList = subCatList;
    }

    public Integer getFatherId() {
        return fatherId;
    }

    public void setFatherId(Integer fatherId) {
        this.fatherId = fatherId;
    }
}
