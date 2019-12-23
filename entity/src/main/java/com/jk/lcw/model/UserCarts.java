package com.jk.lcw.model;/**
 * @创建人 原国庆
 * @创建时间 2019/12/18
 * @描述
 */

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

/**
 *@ClassName UserCarts
 *@Deacription TODO
 *@Author 原国庆
 *@Date 2019/12/18 10:52
 *@Version 1.0
 **/

public class UserCarts implements Serializable {
    private static final long serialVersionUID = 4340596636229154913L;
    @Id
    private  Integer userid;

    private String shoucangid;

    private List<Cart> list;

    public String getShoucangid() {
        return shoucangid;
    }

    public void setShoucangid(String shoucangid) {
        this.shoucangid = shoucangid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public List<Cart> getList() {
        return list;
    }

    public void setList(List<Cart> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "UserCarts{" +
                "userid=" + userid +
                ", list=" + list +
                '}';
    }
}
