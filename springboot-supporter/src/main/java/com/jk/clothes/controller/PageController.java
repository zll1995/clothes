package com.jk.clothes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("page")
public class PageController {
    @RequestMapping("toareashow")
    public String toareashow(){
        return "areashow";
    }

    @RequestMapping("tobrandshow")
    public String tobrandshow(){
        return "brandshow";
    }

    @RequestMapping("totypeshow")
    public String totypeshow(){
        return "typeshow";
    }

    @RequestMapping("toadvshow")
    public String toadvshow(){
        return "advshow";
    }

    @RequestMapping("toaddadv")
    public String toaddadc(){
        return "addadv";
    }

    @RequestMapping("toordershow")
    public String toordershow(){
        return "ordershow";
    }

    @RequestMapping("toaddorder")
    public String toaddorder(){
        return "addorder";
    }

    @RequestMapping("toindex")
    public String toindex(){
        return "/user/index";
    }
}
