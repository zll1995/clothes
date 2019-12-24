package com.jk.user.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("page")
public class PageController {

    //跳转到注册页面
    @RequestMapping("toRegister")
    public String toRegister(){
        return "register";
    }

    //跳转到注册页面
    @RequestMapping("toPhone")
    public String toPhone(){
        return "toPhone";
    }
}
