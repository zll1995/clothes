package com.jk.clothes.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName Product
 * @Description
 * @Author
 * @Date 2019/12/13 10:34
 * @Version V1.0
 **/
public class Product implements Serializable {

    private static final long serialVersionUID = -2129538033412953704L;

    private Integer productId;

    private String productName;

    private String productCode;

    private Integer productArt;

    private String productModel;

    private String productPly;

    private String productCollarType;

    private String fashionElement;

    private String downContent;

    private String productFiller;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date market;

    private Integer productArea;

    private String areaName;

    private String productStyle;

    private String suitable;

    private String outsideSleeve;

    private Integer typeid;

    private String typeName;

    private Integer productStatus;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date sdTime;

    private String describes;

    private String pantsType;

    private Integer outsideLength;

    private String waistFull;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public Integer getProductArt() {
        return productArt;
    }

    public void setProductArt(Integer productArt) {
        this.productArt = productArt;
    }

    public String getProductModel() {
        return productModel;
    }

    public void setProductModel(String productModel) {
        this.productModel = productModel;
    }

    public String getProductPly() {
        return productPly;
    }

    public void setProductPly(String productPly) {
        this.productPly = productPly;
    }

    public String getProductCollarType() {
        return productCollarType;
    }

    public void setProductCollarType(String productCollarType) {
        this.productCollarType = productCollarType;
    }

    public String getFashionElement() {
        return fashionElement;
    }

    public void setFashionElement(String fashionElement) {
        this.fashionElement = fashionElement;
    }

    public String getDownContent() {
        return downContent;
    }

    public void setDownContent(String downContent) {
        this.downContent = downContent;
    }

    public String getProductFiller() {
        return productFiller;
    }

    public void setProductFiller(String productFiller) {
        this.productFiller = productFiller;
    }

    public Date getMarket() {
        return market;
    }

    public void setMarket(Date market) {
        this.market = market;
    }

    public Integer getProductArea() {
        return productArea;
    }

    public void setProductArea(Integer productArea) {
        this.productArea = productArea;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getProductStyle() {
        return productStyle;
    }

    public void setProductStyle(String productStyle) {
        this.productStyle = productStyle;
    }

    public String getSuitable() {
        return suitable;
    }

    public void setSuitable(String suitable) {
        this.suitable = suitable;
    }

    public String getOutsideSleeve() {
        return outsideSleeve;
    }

    public void setOutsideSleeve(String outsideSleeve) {
        this.outsideSleeve = outsideSleeve;
    }

    public Integer getTypeid() {
        return typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Integer getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(Integer productStatus) {
        this.productStatus = productStatus;
    }

    public Date getSdTime() {
        return sdTime;
    }

    public void setSdTime(Date sdTime) {
        this.sdTime = sdTime;
    }

    public String getDescribes() {
        return describes;
    }

    public void setDescribes(String describes) {
        this.describes = describes;
    }

    public String getPantsType() {
        return pantsType;
    }

    public void setPantsType(String pantsType) {
        this.pantsType = pantsType;
    }

    public Integer getOutsideLength() {
        return outsideLength;
    }

    public void setOutsideLength(Integer outsideLength) {
        this.outsideLength = outsideLength;
    }

    public String getWaistFull() {
        return waistFull;
    }

    public void setWaistFull(String waistFull) {
        this.waistFull = waistFull;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", productCode='" + productCode + '\'' +
                ", productArt=" + productArt +
                ", productModel='" + productModel + '\'' +
                ", productPly='" + productPly + '\'' +
                ", productCollarType='" + productCollarType + '\'' +
                ", fashionElement='" + fashionElement + '\'' +
                ", downContent='" + downContent + '\'' +
                ", productFiller='" + productFiller + '\'' +
                ", market=" + market +
                ", productArea=" + productArea +
                ", areaName='" + areaName + '\'' +
                ", productStyle='" + productStyle + '\'' +
                ", suitable='" + suitable + '\'' +
                ", outsideSleeve='" + outsideSleeve + '\'' +
                ", typeid=" + typeid +
                ", typeName='" + typeName + '\'' +
                ", productStatus=" + productStatus +
                ", sdTime=" + sdTime +
                ", describes='" + describes + '\'' +
                ", pantsType='" + pantsType + '\'' +
                ", outsideLength=" + outsideLength +
                ", waistFull='" + waistFull + '\'' +
                '}';
    }
}
