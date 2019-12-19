package com.jk.tree.controller;/**
 * @创建人 原国庆
 * @创建时间 2019/12/13
 * @描述
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *@ClassName ToController
 *@Deacription TODO
 *@Author 原国庆
 *@Date 2019/12/13 10:42
 *@Version 1.0
 **/
@Controller
@RequestMapping("to")
public class ToController {

    @RequestMapping("main")
    public String toMain(){
        return  "main";
    }
}
