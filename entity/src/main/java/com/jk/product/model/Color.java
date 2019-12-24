package com.jk.product.model;

import java.io.Serializable;
import java.util.List;

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
    private String sizeName;
    private String colorImg;
    private Integer productId;

    private List<Size> showSize;

    public List<Size> getShowSize() {
        return showSize;
    }

    public void setShowSize(List<Size> showSize) {
        this.showSize = showSize;
    }

    public String getColorImg() {
        return colorImg;
    }

    public void setColorImg(String colorImg) {
        this.colorImg = colorImg;
    }

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
