package com.jk.lcw.model;/**
 * @创建人 原国庆
 * @创建时间 2019/12/25
 * @描述
 */

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 *@ClassName Order
 *@Deacription TODO
 *@Author 原国庆
 *@Date 2019/12/25 13:44
 *@Version 1.0
 **/
public class Order {

    private Integer orderId; //订单id; int
    private Integer shangpinId;//商品id', int
    private  String shangpinName;//商品标题 var
    private String shangpinImg;//封面图'，var
    private String zfbId;//支付宝id var
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date orderDate;//订单时间 date
    private  String xiaDanRen;//下单人 var
    private String xdrPhone;//下单人手机号，var
    private String address;//地址，var
    private double shangpinprice;//地址，var

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getShangpinId() {
        return shangpinId;
    }

    public void setShangpinId(Integer shangpinId) {
        this.shangpinId = shangpinId;
    }

    public String getShangpinName() {
        return shangpinName;
    }

    public void setShangpinName(String shangpinName) {
        this.shangpinName = shangpinName;
    }

    public String getShangpinImg() {
        return shangpinImg;
    }

    public void setShangpinImg(String shangpinImg) {
        this.shangpinImg = shangpinImg;
    }

    public String getZfbId() {
        return zfbId;
    }

    public void setZfbId(String zfbId) {
        this.zfbId = zfbId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getXiaDanRen() {
        return xiaDanRen;
    }

    public void setXiaDanRen(String xiaDanRen) {
        this.xiaDanRen = xiaDanRen;
    }

    public String getXdrPhone() {
        return xdrPhone;
    }

    public void setXdrPhone(String xdrPhone) {
        this.xdrPhone = xdrPhone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getShangpinprice() {
        return shangpinprice;
    }

    public void setShangpinprice(double shangpinprice) {
        this.shangpinprice = shangpinprice;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", shangpinId=" + shangpinId +
                ", shangpinName='" + shangpinName + '\'' +
                ", shangpinImg='" + shangpinImg + '\'' +
                ", zfbId='" + zfbId + '\'' +
                ", orderDate=" + orderDate +
                ", xiaDanRen='" + xiaDanRen + '\'' +
                ", xdrPhone='" + xdrPhone + '\'' +
                ", address='" + address + '\'' +
                ", shangpinprice=" + shangpinprice +
                '}';
    }
}
