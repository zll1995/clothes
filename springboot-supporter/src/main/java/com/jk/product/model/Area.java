package com.jk.product.model;

import java.io.Serializable;

/**
 * @ClassName Area
 * @Description
 * @Author
 * @Date 2019/12/13 11:25
 * @Version V1.0
 **/
public class Area implements Serializable {
    private static final long serialVersionUID = -4420526468187953891L;

    private Integer id;

    private String areaName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }
}
