package com.jk.user.model;/**
 * @创建人 原国庆
 * @创建时间 2019/12/13
 * @描述
 */

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 *@ClassName WebUser
 *@Deacription TODO
 *@Author 原国庆
 *@Date 2019/12/13 15:59
 *@Version 1.0
 **/
public class WebUser implements Serializable {
    private static final long serialVersionUID = -7044768168964713979L;

    private Integer  userid;
    private String username;
    private String password;
    private String usermoney;
    private String userinfo;
    private String userimg;
    private Integer userage;
    private Integer userSex;
    private Integer uservip;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdate;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
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

    public String getUserimg() {
        return userimg;
    }

    public void setUserimg(String userimg) {
        this.userimg = userimg;
    }

    public Integer getUserage() {
        return userage;
    }

    public void setUserage(Integer userage) {
        this.userage = userage;
    }

    public Integer getUserSex() {
        return userSex;
    }

    public void setUserSex(Integer userSex) {
        this.userSex = userSex;
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


    @Override
    public String toString() {
        return "WebUser{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", usermoney='" + usermoney + '\'' +
                ", userinfo='" + userinfo + '\'' +
                ", userimg='" + userimg + '\'' +
                ", userage=" + userage +
                ", userSex=" + userSex +
                ", uservip=" + uservip +
                ", createdate=" + createdate +
                '}';
    }
}
