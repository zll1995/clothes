package com.jk.product.model;

import java.io.Serializable;

/**
 * @ClassName Color
 * @Description
 * @Author
 * @Date 2019/12/16 13:37
 * @Version V1.0
 **/
public class Color implements Serializable {
    private static final long serialVersionUID = -6996167706877236232L;
    private Integer colorid;
    private String colorName;
    private Integer productId;

    public Integer getColorid() {
        return colorid;
    }

    public void setColorid(Integer colorid) {
        this.colorid = colorid;
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "Color{" +
                "colorid=" + colorid +
                ", colorName='" + colorName + '\'' +
                ", productId=" + productId +
                '}';
    }
}
