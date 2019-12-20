package com.jk.clothes.model;

import java.io.Serializable;

/**
 * @ClassName Brand
 * @Description
 * @Author
 * @Date 2019/12/13 11:24
 * @Version V1.0
 **/
public class Brand implements Serializable {
    private static final long serialVersionUID = 8867502543458751984L;

    private Integer brandId;

    private String brandName;

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }
}
