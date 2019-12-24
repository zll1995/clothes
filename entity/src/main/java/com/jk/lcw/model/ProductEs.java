package com.jk.lcw.model;/**
 * @创建人 原国庆
 * @创建时间 2019/12/19
 * @描述
 */

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;

/**
 *@ClassName ProductEs
 *@Deacription TODO
 *@Author 原国庆
 *@Date 2019/12/19 20:41
 *@Version 1.0
 **/
@Document(indexName = "productindex1", type = "product1", shards = 3)
public class ProductEs implements Serializable {
    private static final long serialVersionUID = -4811157107215281563L;

    @Id
    private Integer id;
    @Field(type = FieldType.Text,analyzer = "ik_max_word",searchAnalyzer = "ik_max_word",copyTo = "copy")
    private String productname;
    @Field(type = FieldType.Text,analyzer = "ik_max_word",searchAnalyzer = "ik_max_word",copyTo = "copy")
    private String  sizeimg;
    @Field(type = FieldType.Double,analyzer = "ik_max_word",searchAnalyzer = "ik_max_word",copyTo = "copy")
    private double sizeprice;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getSizeimg() {
        return sizeimg;
    }

    public void setSizeimg(String sizeimg) {
        this.sizeimg = sizeimg;
    }

    public double getSizeprice() {
        return sizeprice;
    }

    public void setSizeprice(double sizeprice) {
        this.sizeprice = sizeprice;
    }

    @Override
    public String toString() {
        return "ProductEs{" +
                "id=" + id +
                ", productname='" + productname + '\'' +
                ", sizeimg='" + sizeimg + '\'' +
                ", sizeprice=" + sizeprice +
                '}';
    }
}
