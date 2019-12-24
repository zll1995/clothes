package com.jk.lcw.model;/**
 * @创建人 原国庆
 * @创建时间 2019/12/17
 * @描述
 */

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 *@ClassName Cart
 *@Deacription TODO
 *@Author 原国庆
 *@Date 2019/12/17 19:29
 *@Version 1.0
 **/

public class Cart implements Serializable {
    private static final long serialVersionUID = -7710921873011703273L;
    @Id
    private Integer productid;

    private String productname;

    private Double productprice;

    private  Integer productCount;

    private String productimg;

    public String getProductimg() {
        return productimg;
    }

    public void setProductimg(String productimg) {
        this.productimg = productimg;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public Double getProductprice() {
        return productprice;
    }

    public void setProductprice(Double productprice) {
        this.productprice = productprice;
    }

    public Integer getProductCount() {
        return productCount;
    }

    public void setProductCount(Integer productCount) {
        this.productCount = productCount;
    }

    public Integer getProductid() {
        return productid;
    }

    public void setProductid(Integer productid) {
        this.productid = productid;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "productid=" + productid +
                ", productname='" + productname + '\'' +
                ", productprice=" + productprice +
                ", productCount=" + productCount +
                ", productimg='" + productimg + '\'' +
                '}';
    }
}
