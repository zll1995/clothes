package com.jk.user.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName User
 * @Deacription TODO
 * @Author 原国庆
 * @Date 2019/12/2 15:14
 * @Version 1.0
 **/

public class User implements Serializable {
    private static final long serialVersionUID = -6670640310551713010L;
    private Integer userid;
    private String username;
    private String password;
    private String usermoney;
    private String userinfo;
    private String img;
    private Integer userage;
    private Integer usersex;
    private Integer uservip;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdate;
    private String userphone;

    private String userimg;


    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }
    public String getUserimg() {
        return userimg;
    }

    public void setUserimg(String userimg) {
        this.userimg = userimg;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsermoney() {
        return usermoney;
    }

    public void setUsermoney(String usermoney) {
        this.usermoney = usermoney;
    }

    public String getUserinfo() {
        return userinfo;
    }

    public void setUserinfo(String userinfo) {
        this.userinfo = userinfo;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Integer getUserage() {
        return userage;
    }

    public void setUserage(Integer userage) {
        this.userage = userage;
    }

    public Integer getUsersex() {
        return usersex;
    }

    public void setUsersex(Integer usersex) {
        this.usersex = usersex;
    }

    public Integer getUservip() {
        return uservip;
    }

    public void setUservip(Integer uservip) {
        this.uservip = uservip;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public String getUserphone() {
        return userphone;
    }

    public void setUserphone(String userphone) {
        this.userphone = userphone;
    }

    @Override
    public String toString() {
        return "User{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", usermoney='" + usermoney + '\'' +
                ", userinfo='" + userinfo + '\'' +
                ", img='" + img + '\'' +
                ", userage=" + userage +
                ", usersex=" + usersex +
                ", uservip=" + uservip +
                ", createdate=" + createdate +
                ", userphone='" + userphone + '\'' +
                '}';
    }
}
