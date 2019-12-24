package com.jk.product.model;

import java.io.Serializable;

/**
 * @ClassName Size
 * @Description
 * @Author
 * @Date 2019/12/16 19:05
 * @Version V1.0
 **/
public class Size implements Serializable {
    private static final long serialVersionUID = 1384443860039300455L;

    private Integer sizeId;
    private String sizeName;
    private Integer sizeCount;
    private Double sizePrice;
    private String sizePack;
    private String sizeImg;
    private String colorName;
    private Integer colorId;

    public Integer getSizeId() {
        return sizeId;
    }

    public void setSizeId(Integer sizeId) {
        this.sizeId = sizeId;
    }

    public String getSizeName() {
        return sizeName;
    }

    public void setSizeName(String sizeName) {
        this.sizeName = sizeName;
    }

    public Integer getSizeCount() {
        return sizeCount;
    }

    public void setSizeCount(Integer sizeCount) {
        this.sizeCount = sizeCount;
    }

    public Double getSizePrice() {
        return sizePrice;
    }

    public void setSizePrice(Double sizePrice) {
        this.sizePrice = sizePrice;
    }

    public String getSizePack() {
        return sizePack;
    }

    public void setSizePack(String sizePack) {
        this.sizePack = sizePack;
    }

    public String getSizeImg() {
        return sizeImg;
    }

    public void setSizeImg(String sizeImg) {
        this.sizeImg = sizeImg;
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    public Integer getColorId() {
        return colorId;
    }

    public void setColorId(Integer colorId) {
        this.colorId = colorId;
    }

    @Override
    public String toString() {
        return "Size{" +
                "sizeId=" + sizeId +
                ", sizeName='" + sizeName + '\'' +
                ", sizeCount=" + sizeCount +
                ", sizePrice=" + sizePrice +
                ", sizePack='" + sizePack + '\'' +
                ", sizeImg='" + sizeImg + '\'' +
                ", colorName='" + colorName + '\'' +
                ", colorId=" + colorId +
                '}';
    }
}
