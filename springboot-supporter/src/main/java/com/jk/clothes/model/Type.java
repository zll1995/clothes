package com.jk.clothes.model;

import java.io.Serializable;

/**
 * @ClassName Type
 * @Description
 * @Author
 * @Date 2019/12/13 11:26
 * @Version V1.0
 **/
public class Type implements Serializable {
    private static final long serialVersionUID = -6326822047619881111L;

    private Integer typeId;

    private String typeName;

    private Integer brandId;

    private String brandName;

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }
}
