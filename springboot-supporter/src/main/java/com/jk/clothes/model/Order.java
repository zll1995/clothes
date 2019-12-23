package com.jk.clothes.model;


public class Order {

    private String id; //id
    private Integer userId; //用户id
    private String orderNum; //订单 编号
    private String productName; //名称
    private String sizePrice; //价格
    private String sizeImg; //图片
    private String sizeName; //尺码

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getSizePrice() {
        return sizePrice;
    }

    public void setSizePrice(String sizePrice) {
        this.sizePrice = sizePrice;
    }

    public String getSizeImg() {
        return sizeImg;
    }

    public void setSizeImg(String sizeImg) {
        this.sizeImg = sizeImg;
    }

    public String getSizeName() {
        return sizeName;
    }

    public void setSizeName(String sizeName) {
        this.sizeName = sizeName;
    }
}
