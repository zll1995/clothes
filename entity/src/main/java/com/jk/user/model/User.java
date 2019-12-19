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
@Data
public class User implements Serializable {
    private static final long serialVersionUID = -6670640310551713010L;
    private Integer userid;
    private String username;
    private String password;
    private String usermoney;
    private String userinfo;
    private String userimg;
    private Integer userage;
    private Integer usersex;
    private Integer uservip;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdate;

}
