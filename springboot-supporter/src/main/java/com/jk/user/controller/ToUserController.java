package com.jk.user.controller;/**
 * @创建人 原国庆
 * @创建时间 2019/12/13
 * @描述
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *@ClassName ToUserController
 *@Deacription TODO
 *@Author 原国庆
 *@Date 2019/12/13 17:19
 *@Version 1.0
 **/
@Controller
@RequestMapping("to")
public class ToUserController {
    @RequestMapping("goShowUser")
    public String showUser(){
        return "user/showUser";
    }

    @RequestMapping("addUser")
    public String addUser(){
        return "user/addUser";
    }

}
